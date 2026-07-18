import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < elements.length; i++) { // 더할 수의 개수
            for (int j = 0; j < elements.length; j++) { // 시작할 인덱스
                int cnt = 0;
                int sum = 0;
                int idx = j;
                while(cnt < i + 1) {
                    sum += elements[idx];
                    idx = (idx + 1) % elements.length;
                    cnt++;
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}