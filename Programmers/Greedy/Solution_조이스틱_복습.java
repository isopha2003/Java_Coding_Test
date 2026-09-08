import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(String name) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> resolved = new HashSet<>(); // 헤결된 인덱스 저장
        int len = name.length();
        for (int i = 0; i < len; i++) {
            sb.append("A");
        }
        
        int idx = 0;
        int cnt = 0;
        int leftIdx = idx;
        int rightIdx = idx;
        int leftCnt = 0;
        int rightCnt = 0;
        while(!sb.toString().equals(name)) {
            cnt += Math.min(leftCnt, rightCnt);
            idx = (leftCnt < rightCnt) ? leftIdx : rightIdx;
            char n = name.charAt(idx);
            // 알파벳의 변경
            if (n == 'A') {  // word에서 현재 위치한 자리의 알파벳이 name과 같을 때
            } else if (n <= 78) { // name의 알파벳이 N보다 같거나 작을 때
                cnt += (n - 65);
                sb.setCharAt(idx, n);
            } else { // name의 알파벳이 N보다 클 때
                cnt += (90 - n + 1);
                sb.setCharAt(idx, n);
            }
            resolved.add(idx); // 해결된 인덱스 저장
            
            // 자리 이동
            leftIdx = idx;
            leftCnt = 0;
            while(true) { // 왼쪽으로 이동
                leftIdx = (leftIdx - 1 < 0) ? (len - 1) : (leftIdx - 1);
                leftCnt++;
                if (!resolved.contains(leftIdx) && name.charAt(leftIdx) != 'A' || leftCnt >= len) {
                    break;
                }
            }
            rightIdx = idx;
            rightCnt = 0;
            while(true) { // 오른쪽으로 이동
                rightIdx = (rightIdx + 1) % len;
                rightCnt++;
                if (!resolved.contains(rightIdx) && name.charAt(rightIdx) != 'A' || rightCnt >= len) {
                    break;
                }
            }
        }
        return cnt;
    }
}