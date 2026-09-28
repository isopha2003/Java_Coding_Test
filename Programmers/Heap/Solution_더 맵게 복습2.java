import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        while(!queue.isEmpty() && queue.peek() < K) {
            int first = queue.poll();
            if (queue.isEmpty()) {
                return -1;
            }
            int second = queue.poll();
            queue.add(first + second * 2);
            cnt++;
        }
        return cnt;
    }
}