import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        Map<Integer, Integer> count = new HashMap<>();
        // 해시맵에 인용 수와 횟수 저장
        for (int i = 0; i < citations.length; i++) {
            count.put(citations[i], count.getOrDefault(citations[i], 0) + 1);
            
            // 해당 인용 수 보다 적은 횟수를 가진 논문의 횟수 증가
            List<Integer> keys = new ArrayList<>(count.keySet());
            for (int key : keys) {
                if (key < citations[i]) {
                    count.put(key, count.get(key) + 1);
                }
            }
        }
        // H-Index 찾기
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getKey() <= entry.getValue() &&
               entry.getKey() > max) {
                max = entry.getKey();
            }
            else if (entry.getKey() > entry.getValue() &&
                    entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        
        return max;
    }
}