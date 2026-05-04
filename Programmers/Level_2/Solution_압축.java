import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        int index = 1;
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        // 해시맵에 색인 번호와 단어 추가
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), index++);
        }
        String str = "";
        
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            str += c;
            if (map.get(str) == null) { // 해시맵에 해당 키 값이 존재하지 않을 때
                map.put(str, index++); // 해시맵에 해당 값 저장
                list.add(map.get(str.substring(0, str.length() - 1))); // 이전의 문자열의 해시맵 값을 저장
                str = String.valueOf(c);
            }
        }
        if (str != "") { // 마지막 남은 문자 삽입
            list.add(map.get(str));
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}