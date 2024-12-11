class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k == 0) return 0;
        int sum = 0;
        if (k <= numOnes) {
            sum += k;
            k = 0;
        } else {
            k -= numOnes;
            sum += numOnes;
        }
        if (k > 0) {
            if (k <= numZeros) {
                k = 0;
            } else {
                k -= numZeros;
            }
        }
        if (k > 0) {
            if (k <= numNegOnes) {
                sum -= k;
            } else {
                sum -= numNegOnes;
            }
        }
        return sum;
    }
}
