class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int prevIndex = 0;
        for (int i = 0; i < spaces.length; i++) {
            result.append(s.substring(prevIndex, spaces[i]));
            result.append(' ');
            prevIndex = spaces[i];
        }
        result.append(s.substring(prevIndex));
        return result.toString();
    }
}
