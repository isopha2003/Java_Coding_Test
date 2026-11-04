import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[][] times = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) { // 시간을 분으로 변환하여 정수 배열에 저장
            String[] startTime = book_time[i][0].split(":");
            String[] endTime = book_time[i][1].split(":");
            times[i][0] = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            times[i][1] = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]) + 10; // 마감 시간 + 청소 시간
        }
        
        Arrays.sort(times, (t1, t2) -> t1[0] - t2[0]); // 시작 시간을 기준으로 오름차순 정렬
        
        for (int i = 0; i < times.length; i++) {
            if(!queue.isEmpty() && queue.peek() <= times[i][0]) {
                queue.poll();
            }
            queue.offer(times[i][1]);
        }
        return queue.size();
    }
}