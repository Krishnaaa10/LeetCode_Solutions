public class Solution {

    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            if (s.length() % 2 == 0) {
                int first = 0;
                int last = 0;
                for (int j = 0; j < s.length() / 2; j++) {
                    first += Character.getNumericValue(s.charAt(j));
                    last += Character.getNumericValue(s.charAt(s.length() - 1 - j));
                }
                if (first == last) {
                    count++;
                }
            }
        }
        return count;
    }

    // Main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.countSymmetricIntegers(1, 1000); // Try with any range
        System.out.println("Symmetric integers count: " + result);
    }
}
