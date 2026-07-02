import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public long solution(int[] queue1, int[] queue2) {
        Deque<Long> q1 = new ArrayDeque<>();
        Deque<Long> q2 = new ArrayDeque<>();
        long len = queue1.length;
        long totalQ1 = 0;
        long totalQ2 = 0;
        long count = 0;
        
        for (int i = 0; i < len; i++) {
            long n = queue1[i];
            q1.offer(n);
            totalQ1 += n;
        }
        for (int i = 0; i < len; i++) {
            long n = queue2[i];
            q2.offer(n);
            totalQ2 += n;
        }
        
        if ((totalQ1 + totalQ2) % 2 != 0) { // 두 큐의 원소의 합이 홀수일 때
            return -1;
        }
        if (totalQ1 == totalQ2) { // 이미 두 큐의 합이 같을 때
            return count;
        }
        
        while(true) {
            if (totalQ1 == totalQ2) {
                break;
            }
            if (totalQ1 > totalQ2) {
                Long n = q1.poll();
                q2.offer(n);
                if (n == null) {
                    return -1;
                }
                totalQ1 -= n;
                totalQ2 += n;
                count++;
            }
            else {
                Long n = q2.poll();
                q1.offer(n);
                if (n == null) {
                    return -1;
                }
                totalQ1 += n;
                totalQ2 -= n;
                count++;
            }
            if (count >= len * 3) {
                return -1;
            }
        }
        
        return count;
    }
}