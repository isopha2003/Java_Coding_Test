import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    private int row;
    private int col;
    private boolean[][] visited;
    
    public int bfs(int[][] maps) {
        Deque<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {0, 0, 1}); // 행, 열, 이동거리
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == (row - 1) && cur[1] == (col - 1)) {
                return cur[2];
            }
            int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            
            for (int[] m : move) {
                int r = cur[0] + m[0];
                int c = cur[1] + m[1];
                if (r >= row || c >= col || r < 0 || c < 0) {
                    continue;
                }
                else {
                    if (maps[r][c] == 0 || visited[r][c]) {
                        continue;
                    }
                    else {
                        queue.offer(new int[] {r, c, cur[2] + 1});
                        visited[r][c] = true;
                    }
                }
            }
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        row = maps.length;
        col = maps[0].length;
        visited = new boolean[row][col];
        int answer = bfs(maps);
        
        return answer; 
    }     
}