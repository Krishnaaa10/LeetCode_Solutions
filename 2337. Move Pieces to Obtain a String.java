class Solution {
    public boolean canChange(String start, String target) {
        if (!start.replace("_", "").equals(target.replace("_", ""))) return false;
        int p1 = 0, p2 = 0, n = start.length();
        while (p1 < n && p2 < n) {
            while (p1 < n && start.charAt(p1) == '_') p1++;
            while (p2 < n && target.charAt(p2) == '_') p2++;
            if (p1 < n && p2 < n) {
                if (start.charAt(p1) != target.charAt(p2)) return false;
                if (start.charAt(p1) == 'L' && p1 < p2) return false;
                if (start.charAt(p1) == 'R' && p1 > p2) return false;
                p1++;
                p2++;
            }
        }
        return true;
    }
}
