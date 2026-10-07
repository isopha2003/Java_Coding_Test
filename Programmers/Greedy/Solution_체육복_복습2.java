import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> spare = new HashSet<>(); // 여벌 체육복을 가지고 있는 학생
        for (int r : reserve) {
            spare.add(r);
        }
        
        Arrays.sort(lost);
        Set<Integer> stolen = new HashSet<>(); // 체육복을 도둑맞은 학생
        for (int l : lost) {
            stolen.add(l);
            if (spare.contains(l)) { // 잃어버린 학생 자신이 여분의 체육복이 있는 경우
                stolen.remove(l);
                spare.remove(l);
            }
        }
        for (int l : lost) {
              if (spare.contains(l - 1)) { // 잃어버린 학생의 앞 번호 학생이 여분의 체육복이 있는 경우
                stolen.remove(l);
                spare.remove(l - 1);
            } else if (spare.contains(l + 1)) { // 잃어버린 학생의 뒷 번호 학생이 여분의 체육복이 있는 경우
                stolen.remove(l);
                spare.remove(l + 1);
            }
        }
        return n - stolen.size();
    }
}