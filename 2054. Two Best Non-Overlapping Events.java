class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            int currentValue = events[i][2];
            int validIndex = binarySearch(events, events[i][1] + 1);
            if (validIndex != -1) {
                currentValue += suffixMax[validIndex];
            }
            maxSum = Math.max(maxSum, currentValue);
        }
        return maxSum;
    }

    private int binarySearch(int[][] events, int target) {
        int left = 0, right = events.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (left < events.length) ? left : -1;
    }
}
