import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public long solution(int[] weights) {
        long result = 0;
        Arrays.sort(weights); // 오름차순 정렬
        
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < weights.length; i++) {
            map.put(weights[i], map.getOrDefault(weights[i], 0L) + 1);
        }
        
        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            int a = w * 3 / 2;
            int b = w * 2;
            int c = w * 4 / 3;

            if (w * 3 % 2 == 0 && map.containsKey(a)) {
                result += map.get(a);
            } if (map.containsKey(b)) {
                result += map.get(b);
            } if (w * 4 % 3 == 0 && map.containsKey(c)) {
                result += map.get(c);
            }
        }
        
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            Long n = entry.getValue();
            if (n >= 2) {
                result += (n * (n - 1)) / 2;
            } 
        }
        
        return result;
    }
}