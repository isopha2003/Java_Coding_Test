import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        int order = 1;
        Map <String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for (char c = 'A'; c <= 'Z'; c++) { // 해시맵에 알파벳 저장
            map.put(Character.toString(c), order++);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            sb.append(c);
            if (map.get(sb.toString()) == null) { // 해시맵에 해당 단어가 존재하지 않을 때
                map.put(sb.toString(), order++);
                list.add(map.get(sb.substring(0, sb.length() - 1)));
                sb.setLength(0);
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            list.add(map.get(sb.toString()));
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}