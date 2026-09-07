import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(reserve);
        Arrays.sort(lost);
        
        Set<Integer> spare = new HashSet<>(); 
        // 여벌옷이 있는 학생들을 저장할 HashSet
        Set<Integer> temp = new HashSet<>(); 
        // 여벌옷이 있으면서 도난을 당한 학생들을 저장할 HashSet
        
        for (int r : reserve) { // 여벌옷이 있는 학생을 저장
            spare.add(r);
        }
        
        for (int l : lost) { // 여벌옷을 가지고 있으면서 도난당한 학생 제외
            if (spare.contains(l)) {
                spare.remove(l); // 여벌옷 제거
                temp.add(l); // 여벌옷을 가지고 있으면서 도난당한 학생 저장
            }
        }
        
        for (int l : lost) {
            if (temp.contains(l)) { // 여벌옷을 이미 본인이 입은 학생일 때
                continue;
            }
            if (spare.contains(l - 1)) { 
            // 옷을 잃어버린 학생의 앞번호 학생이 여벌옷이 있을 때
                spare.remove(l - 1);
            }
            else if (spare.contains(l + 1)) { 
            // 옷을 잃어버린 학생의 뒷번호 학생이 여벌옷이 있을 때 
                spare.remove(l + 1);
            }
            else { // 옷을 빌릴 수 없을 때
                n--;
            }
        }
        
        return n;
    }
}