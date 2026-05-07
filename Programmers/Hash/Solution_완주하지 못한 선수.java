import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collector;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for (int i = 0 ; i < participant.length; i++) {
            String name = participant[i];
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for (int i = 0; i < completion.length; i++) {
            String name = completion[i];
            map.put(name, map.get(name) - 1);
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                list.add(entry.getKey());
            }
        }
        
        return String.join(", ", list);
    }
}