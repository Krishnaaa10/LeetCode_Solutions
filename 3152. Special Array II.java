class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] sameParity = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            sameParity[i] = (nums[i] % 2 == nums[i + 1] % 2) ? 1 : 0;
        }
        int[] prefixSum = new int[n];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + (i - 1 < sameParity.length ? sameParity[i - 1] : 0);
        }
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0], to = queries[i][1];
            result[i] = (prefixSum[to] - prefixSum[from]) == 0;
        }
        return result;
    }
}
