import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        int idx = 1;
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(c + "", idx++);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            String s = sb.toString();
            char c = msg.charAt(i);
            sb.append(c);
            if (!sb.isEmpty() && !map.containsKey(sb.toString())) {
                map.put(sb.toString(), idx++);
                sb.setLength(0);
                sb.append(c);
                list.add(map.get(s));
            }
        }
        if (!sb.isEmpty()) {
            list.add(map.get(sb.toString()));
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}