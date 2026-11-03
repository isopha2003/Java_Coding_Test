import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int solution(String[] maps) {
        int rowLen = maps.length;
        int colLen = maps[0].length();
        boolean[][] visited;
        Deque<int[]> queue = new ArrayDeque<>();
        visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) { // 시작 위치 찾기
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    queue.offer(new int[]{i, j, 0});
                    break;
                }
            }
        }
        boolean findL = false;
        while(!queue.isEmpty()) { // 레버 위치 찾기
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int cnt = cur[2];
            
            if (maps[row].charAt(col) == 'L') {
                findL = true;
                for (int i = 0; i < visited.length; i++) {
                    Arrays.fill(visited[i], false);
                }
                queue.clear();
                queue.offer(new int[]{row, col, cnt});
                break;
            }
            
            if (row - 1 >= 0 && !visited[row - 1][col] && maps[row - 1].charAt(col) != 'X') {
                visited[row - 1][col] = true;
                queue.offer(new int[]{row - 1, col, cnt + 1});
            }
            if (row + 1 < rowLen && !visited[row + 1][col] && maps[row + 1].charAt(col) != 'X') {
                visited[row + 1][col] = true;
                queue.offer(new int[]{row + 1, col, cnt + 1});
            }
            if (col - 1 >= 0 && !visited[row][col - 1] && maps[row].charAt(col - 1) != 'X') {
                visited[row][col - 1] = true;
                queue.offer(new int[]{row, col - 1, cnt + 1});
            }
            if (col + 1 < colLen && !visited[row][col + 1] && maps[row].charAt(col + 1) != 'X') {
                visited[row][col + 1] = true;
                queue.offer(new int[]{row, col + 1, cnt + 1});
            }
        }
        if (!findL) return -1;
        
        boolean findE = false;
        while(!queue.isEmpty()) { // 출구 위치 찾기
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int cnt = cur[2];
            
            if (maps[row].charAt(col) == 'E') {
                findE = true;
                queue.clear();
                queue.offer(new int[]{row, col, cnt});
                break;
            }
            
            if (row - 1 >= 0 && !visited[row - 1][col] && maps[row - 1].charAt(col) != 'X') {
                visited[row - 1][col] = true;
                queue.offer(new int[]{row - 1, col, cnt + 1});
            }
            if (row + 1 < rowLen && !visited[row + 1][col] && maps[row + 1].charAt(col) != 'X') {
                visited[row + 1][col] = true;
                queue.offer(new int[]{row + 1, col, cnt + 1});
            }
            if (col - 1 >= 0 && !visited[row][col - 1] && maps[row].charAt(col - 1) != 'X') {
                visited[row][col - 1] = true;
                queue.offer(new int[]{row, col - 1, cnt + 1});
            }
            if (col + 1 < colLen && !visited[row][col + 1] && maps[row].charAt(col + 1) != 'X') {
                visited[row][col + 1] = true;
                queue.offer(new int[]{row, col + 1, cnt + 1});
            }
        }
        if (!findE) return -1;
        
        return queue.poll()[2];
    }
}