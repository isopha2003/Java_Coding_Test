import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[y + 1];
        queue.add(new int[]{x, 0});
        visited[x] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int X = cur[0], count = cur[1];
            
            if (X == y) {
                return count;
            }
            if (X * 2 <= y && !visited[X * 2]) {
                queue.add(new int[]{X * 2, count + 1});
                visited[X * 2] = true;
            }
            if (X * 3 <= y && !visited[X * 3]) {
                queue.add(new int[]{X * 3, count + 1});
                visited[X * 3] = true;
            }
            if (X + n <= y && !visited[X + n]) {
                queue.add(new int[]{X + n, count + 1});
                visited[X + n] = true;
            }
            
        }
        
        return -1;
    }
}