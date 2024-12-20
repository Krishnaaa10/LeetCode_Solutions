import java.util.HashMap;
import java.util.Map;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String s : arr) count.put(s, count.getOrDefault(s, 0) + 1);
        for (String s : arr) if (count.get(s) == 1 && --k == 0) return s;
        return "";
    }
}
