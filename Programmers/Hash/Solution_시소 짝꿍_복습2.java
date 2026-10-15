import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public long solution(int[] weights) {
        long result = 0;
        Arrays.sort(weights);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < weights.length; i++) {
            map.put(weights[i], map.getOrDefault(weights[i], 0) + 1);
        }
        
        for (int i = 0; i < weights.length; i++) {
            int n = weights[i];
            int a = n % 2 == 0 ? 3 * n / 2 : 0;
            int b = 2 * n;
            int c = n % 3 == 0 ? 2 * n / 3 : 0;
            int d = n % 3 == 0 ? 4 * n / 3 : 0;
            int e = n % 2 == 0 ? n / 2 : 0;
            int f = n % 4 == 0 ? (3 * n) / 4 : 0;
            
            if (map.containsKey(a) && a > n) {
                result += map.get(a);
            } 
            if (map.containsKey(b) && b > n) {
                result += map.get(b);
            } 
            if (map.containsKey(c) && c > n) {
                result += map.get(c);
            } 
            if (map.containsKey(d) && d > n) {
                result += map.get(d);
            } 
            if (map.containsKey(e) && e > n) {
                result += map.get(e);
            } 
            if (map.containsKey(f) && f > n) {
                result += map.get(f);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            long value = entry.getValue();
            if (value > 1) {
                result += (value * (value - 1)) / 2;
            }
        }
        
        return result;
    }
}