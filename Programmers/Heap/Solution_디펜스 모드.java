import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        if (k > enemy.length) return enemy.length;
        
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < enemy.length; i++) {
            int e = enemy[i];
            pq.offer(e);
            n -= e;
            if (n < 0) {
                if (k > 0) {
                    int max = pq.poll();
                    n += max;
                    k--;
                }
                else {
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}