import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();        
                
        // 필요 필요도와 소모 필요도 비율 계산하여 해시맵에 저장
        for (int i = 0; i < dungeons.length; i++) {
            int ratio = dungeons[i][0] - dungeons[i][1];
            map.put(i, ratio);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (a, b) -> b.getValue() - a.getValue());
        
        for (Map.Entry<Integer, Integer> entry : entries) {
            int i = entry.getKey();
            if (k < dungeons[i][0]) {
                continue;
            } 
            else {
                k -= dungeons[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}