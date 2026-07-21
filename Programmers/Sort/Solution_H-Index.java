import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < citations.length; i++) {
            for (Integer key : map.keySet()) {
                if (key < citations[i]) {
                    map.put(key, map.get(key) + 1);
                }
            }
            map.put(citations[i], map.getOrDefault(citations[i], 0) + 1);
        }
        int h = 0;
        for (Integer key : map.keySet()) {
            int n = Math.min(key, map.get(key));
            h = (h <= n ? n : h);
        }
        
        return h;
    }
}