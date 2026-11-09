import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        List<Integer>[] place = new ArrayList[N + 1];
        Arrays.sort(road, (a, b) -> a[2] - b[2]);
        
        for (int i = 0; i <= N; i++) {
            place[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < road.length; i++) {
            place[road[i][0]].add(road[i][1]);
            place[road[i][1]].add(road[i][0]);
            // 각 마을에서 이동할 때 걸리는 시간을 저장
            place[road[i][0]].add(road[i][2]);
            place[road[i][1]].add(road[i][2]);
            // (갈 수 있는 마을, 걸리는 시간), (갈 수 있는 마을, 걸리는 시간)...
        }
        
        Deque<List<Integer>> placeQueue = new ArrayDeque<>();
        Deque<Integer> timeQueue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        boolean[] counted = new boolean[N + 1];
        placeQueue.offer(place[1]);
        visited[1] = true;
        counted[1] = true;
        timeQueue.offer(0);
    
        while(!placeQueue.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            cur = placeQueue.poll();
            int totalTime = timeQueue.poll();
            for (int i = 0; i < cur.size(); i += 2) {
                int p = cur.get(i);
                int t = cur.get(i + 1);
                if (!counted[p] && totalTime + t <= K) {
                    counted[p] = true;
                    answer++;
                }
                if (!visited[p]) {
                    visited[p] = true;
                    placeQueue.offer(place[p]);
                    timeQueue.offer(totalTime + t);
                }
            }
        }
        return answer;
    }
}