import java.util.Map;
import java.util.LinkedHashMap;

class Solution {
    // 현재 해시맵에서 가장 큰 값 탐색
    public int findMax(Map<Integer, Integer> map) {
        int max = 0;
        for (int value : map.values()) {
            if (value > max) {
                max = value; 
            }
        }
        return max;
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int len = priorities.length;
        
        Map<Integer, Integer> map = new LinkedHashMap<>();
        
        // 우선순위와 인덱스를 해시맵에 저장
        for (int i = 0; i < len; i++) {
            map.put(i, priorities[i]); 
        }
        
        int count = 1;
        while(true) {
            int max = findMax(map);
            int firstKey = 0;
            int firstValue = 0;
            
            // 첫 번째 키와 값 얻기
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                firstKey = entry.getKey();
                firstValue = entry.getValue();
                break;
            }
            if (max == priorities[location] && location == firstKey) {
                break;
            }
            
            if (max == firstValue) { // 맨 앞의 값의 우선순위가 가장 높다면
                map.remove(firstKey); // 목록에서 제거
                answer++;
            }
            else { // 맨 앞의 값이 우선순위가 가장 높은 값이 아니라면
                map.remove(firstKey);
                map.put(firstKey, firstValue); // 맨 뒤로 보내기
            }
            
        }
        return answer;
    }
}