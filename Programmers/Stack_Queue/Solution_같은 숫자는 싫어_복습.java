import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] arr) {
        int cur;
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < arr.length; i++) {
            cur = arr[i];
            if (queue.isEmpty() || queue.peekLast() != cur) {
                queue.offer(cur);
            }
        }
        int[] answer = new int[queue.size()];
        int idx = 0;
        while (!queue.isEmpty()) {
            answer[idx++] = queue.poll(); 
        }
        
        return answer;
    }
}