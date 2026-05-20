import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        List<Integer> losts = new ArrayList<>();
        Map<Integer, Integer> reserves = new HashMap<>();
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < lost.length; i++) {
            losts.add(lost[i]);
        }
        
        for (int i = 0; i < reserve.length; i++) {
            reserves.put(reserve[i], 1);
        }
        
        for (int i = 0; i < lost.length; i++) { // 여벌의 체육복을 가지고 있는 학생이 도난당했을 경우
            int stu = lost[i];
            if (reserves.get(stu) != null) {
                answer++;
                reserves.put(stu, 0);
                losts.remove(Integer.valueOf(stu));
            }
        }
        
        for (int i = 0; i < losts.size(); i++) {
            int stu = losts.get(i);
            Integer stu1 = reserves.get(stu - 1);
            Integer stu2 = reserves.get(stu + 1);
            
            if (stu1 != null && stu1 != 0) { // 도난당한 학생의 앞번호 학생이 여벌의 체육복을 가지고 있는 경우
                answer++;
                reserves.put(stu - 1, 0);
            }
            
            else if (stu2 != null && stu2 != 0) { // 도난당한 학생의 뒷번호 학생이 여벌의 체육복을 가지고 있는 경우
                answer++;
                reserves.put(stu + 1, 0);
            }
        }
        
        return answer;
    }
}