import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> list = new HashMap<>();
        int total = 0;
        for (int n : number) {
            total += n;
        }
        // 원하는 리스트 해시맵에 저장
        for (int i = 0; i < want.length; i++) {
            list.put(want[i], number[i]);
        }
        boolean isSame = true;
        for (int i = 0; i <= discount.length - total; i++) {
            Map<String, Integer> temp = new HashMap<>();
            isSame = true;
            // want의 길이만큼 HashMap에 저장
            for (int j = 0; j < total; j++) {
                temp.put(discount[j + i], temp.getOrDefault(discount[j + i], 0) + 1);    
            }
            for (Map.Entry<String, Integer> entry : list.entrySet()) {
                Integer value = temp.get(entry.getKey());
                if (value == null){
                    isSame = false;
                    break;
                }
                if (entry.getValue() > value) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) { answer++; }
        }
        return answer;
    }
}