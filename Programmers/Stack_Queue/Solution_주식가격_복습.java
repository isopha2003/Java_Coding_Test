import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<int[]> stack = new ArrayDeque<>();
        
        int cnt = -1;
        for (int i = 0; i < prices.length; i++) {
            cnt++;
            while(!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] s = stack.pop();
                answer[s[0]] = cnt - s[0];
            }
            stack.push(new int[]{i, prices[i]});      
        }
        while(!stack.isEmpty()) {
            int[] s = stack.pop();
            answer[s[0]] = cnt - s[0];
        }
        
        return answer;
    }
}