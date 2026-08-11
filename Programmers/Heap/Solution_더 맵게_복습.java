import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int k : scoville) {
            pq.add(k);
        }
        
        while(pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            int key1 = pq.poll();
            int key2 = pq.poll();
            pq.add(key1 + key2 * 2);
            cnt++;
        }
        
        return cnt;
    }
}