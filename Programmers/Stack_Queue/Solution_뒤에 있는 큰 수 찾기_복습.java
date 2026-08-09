import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] result = new int[len];
        
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while(!stack.isEmpty() && numbers[i] > stack.peek()[1]) {
                int[] arr = stack.pop();
                result[arr[0]] = numbers[i];
            }
            stack.push(new int[]{ i, numbers[i] });
        }
        while(!stack.isEmpty()) {
            int[] arr = stack.pop();
            result[arr[0]] = -1;
        }
        
        return result;
    }
}