import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] orders) {
        int cur = 1;
        int answer = 0;
        Deque<Integer> sub = new ArrayDeque<>();
        
        int idx = 0;
        while(true) {
            if (!sub.isEmpty() && sub.peek() == orders[idx]) {
                sub.pop();
                answer++;
                idx++;
            }
            else sub.push(cur++);
            if (idx >= orders.length || !sub.isEmpty() && sub.peek() > orders[idx]) break;
        }
        
        return answer;
    }
}