import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int n;
        int[] answer = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < len; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                n = stack.pop();
                answer[n] = i - n;
            }
            stack.push(i); // [0]: 인덱스값, [1]: 실제 값
        }
        while(!stack.isEmpty()) {
            n = stack.pop();
            answer[n] = len - n - 1;
        }
        
        return answer;
    }
}