import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>();    
        
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int n = arr[i];
            if (stack.peek() == n) {
                continue;
            }
            else {
                stack.push(n);
            }
        }
        int len = stack.size();
        int answer[] = new int[len];
        
        for (int i = 0; i < len; i++) {
            answer[i] = stack.pollLast();
        }

        return answer;
    }
}