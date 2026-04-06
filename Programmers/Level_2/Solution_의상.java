import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> closet = new HashMap<>();
        for (int i = 0 ; i < clothes.length; i++) {
            closet.put(clothes[i][1], closet.getOrDefault(clothes[i][1], 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : closet.entrySet()) {
            answer *= entry.getValue() + 1;
        }
        
        return answer - 1;
    }
}