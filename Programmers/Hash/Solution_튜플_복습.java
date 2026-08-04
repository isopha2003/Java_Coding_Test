import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer>map = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(2));
        
        for (int i = 3; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '{' && c != '}' && c != ',') { // 숫자일 때,
                sb.append(c);
            }
            if (sb.length() > 0 && (c == '}' || c == ',')) {
                Integer n = Integer.parseInt(sb.toString());
                map.put(n, map.getOrDefault(n, 0) + 1);
                sb.delete(0, sb.length());
            }
        }
        int[] result = new int[map.size()];
        int idx = 0;
        while(!map.isEmpty()) {
            int maxKey = 0;
            int maxValue = 0;
            
            for (Integer key : map.keySet()) {
                if (map.get(key) > maxValue) {
                    maxKey = key;
                    maxValue = map.get(key);
                }
            }
            map.remove(maxKey);
            result[idx++] = maxKey;
        }
        return result;
    }
}