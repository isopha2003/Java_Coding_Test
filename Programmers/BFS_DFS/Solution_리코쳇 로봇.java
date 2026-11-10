import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(String[] board) {
        int ROW = board.length;
        int COL = board[0].length();
        boolean[][] visited = new boolean[board.length][board[0].length()];
        Deque<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < ROW; i++) { // 시작 위치 R 찾기
            boolean find = false;
            for (int j = 0; j < COL; j++) {
                if (board[i].charAt(j) == 'R') {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j, 0});
                    find = true;
                    break;
                }
            }
            if (find) break;
        }
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int cnt = cur[2];
            if (board[row].charAt(col) == 'G') {
                return cnt;
            }
            while (row - 1 >= 0 && board[row - 1].charAt(col) != 'D') {
                row--;
            }
            if (!visited[row][col]) {
                queue.offer(new int[]{row, col, cnt + 1});
                visited[row][col] = true;
            }
            row = cur[0];
            col = cur[1];
            while (row + 1 < ROW && board[row + 1].charAt(col) != 'D') {
                row++;
            }
            if (!visited[row][col]) {
                queue.offer(new int[]{row, col, cnt + 1});
                visited[row][col] = true;
            }
            row = cur[0];
            col = cur[1];
            while (col - 1 >= 0 && board[row].charAt(col - 1) != 'D') {
                col--;
            }
            if (!visited[row][col]) {
                queue.offer(new int[]{row, col, cnt + 1});
                visited[row][col] = true;
            }
            row = cur[0];
            col = cur[1];
            while (col + 1 < COL && board[row].charAt(col + 1) != 'D') {
                col++;
            }
            if (!visited[row][col]) {
                queue.offer(new int[]{row, col, cnt + 1});
                visited[row][col] = true;
            }
        }
        return -1;
    }
}