import java.util.Map;
import java.util.HashMap;

class Solution {
    public long solution(int[] weights) {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] ratio = {{1, 2}, {2, 1}, {2, 3}, {3, 2}, {3, 4}, {4, 3}};
        long result = 0;
        
        for (int i = 0; i < weights.length; i++) { // 몸무게 별 사람 수 저장
            map.put(weights[i], map.getOrDefault(weights[i], 0) + 1);
        }
        
        for (Integer w : map.keySet()) {
            for (int j = 0; j < ratio.length; j++) {
                int p = ratio[j][0];
                int q = ratio[j][1];
                
                int n = (w * q) / p;
                
                if ((w * q) % p == 0 && n >= 100 && n <= 1000) {
                    Integer r = map.get(n);
                    if (r != null) {
                        result += (long) map.get(w) * r;   
                    }
                }
            }
        }
        result /= 2;
        for (Integer key : map.keySet()) {
            long w = map.get(key);
            
            result += (w * (w - 1)) / 2;
        }
        
        return result;
    }
}