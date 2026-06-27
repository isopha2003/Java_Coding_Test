import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        int len = record.length;
        Map<String, String> map = new HashMap<>(); // uid와 이름 저장
        List<String[]> access = new ArrayList<>(); // 출입 여부와 uid 저장
        
        for (int i = 0; i < len; i++) {
            String info[] = record[i].split(" ");
            
            if (!info[0].equals("Leave")) {
                map.put(info[1], info[2]); // uid와 이름 저장
            }
            access.add(new String[]{info[0], info[1]});
        }
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < access.size(); i++) {
            if (access.get(i)[0].equals("Change")) {
                continue;
            }
            
            String name = map.get(access.get(i)[1]); // uid로 이름 찾기
            
            if (access.get(i)[0].equals("Enter")) {
                result.add(name + "님이 들어왔습니다.");
            }
            else {
                result.add(name + "님이 나갔습니다.");
            }
        }
        
        return result.toArray(new String[0]);
    }
}