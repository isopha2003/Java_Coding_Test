import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

class Coordinate {
    private int row;
    private int col;
    private int cnt;
    public Coordinate(int row, int col, int cnt) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public int getCnt() {
        return cnt;
    }
}

class Solution {
    private boolean[][] visited;
    public int solution(String[] maps) {
        int answer = 0;
        int row = maps.length;
        int col = maps[0].length();
        visited = new boolean[maps.length][maps[0].length()];
        Deque<Coordinate> queue = new ArrayDeque<>();
        
        for (int i = 0; i < maps.length; i++) { // 시작 지점 찾기
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    queue.offer(new Coordinate(i, j, 0));
                    break;
                }        
            }
        }
        
        
        boolean findL = false;
        while (!queue.isEmpty()) { // 레버 찾기
            Coordinate cur = queue.poll();
            int sRow = cur.getRow();
            int sCol = cur.getCol();
            int cnt = cur.getCnt();
            visited[sRow][sCol] = true;
            if (maps[sRow].charAt(sCol) == 'L') {
                findL = true;
                queue.clear();
                for (boolean[] v : visited) Arrays.fill(v, false);
                queue.offer(new Coordinate(sRow, sCol, cnt));
                break;
            }
            if (sRow - 1 >= 0 && !visited[sRow - 1][sCol] && maps[sRow - 1].charAt(sCol) != 'X') {
                visited[sRow - 1][sCol] = true;
                queue.offer(new Coordinate(sRow - 1, sCol, cnt + 1));
            }
            if (sRow + 1 < row && !visited[sRow + 1][sCol] && maps[sRow + 1].charAt(sCol) != 'X') {
                visited[sRow + 1][sCol] = true;
                queue.offer(new Coordinate(sRow + 1, sCol, cnt + 1));
            }
            if (sCol - 1 >= 0 && !visited[sRow][sCol - 1] && maps[sRow].charAt(sCol - 1) != 'X') {
                visited[sRow][sCol - 1] = true;
                queue.offer(new Coordinate(sRow, sCol - 1, cnt + 1));
            }          
            if (sCol + 1 < col && !visited[sRow][sCol + 1] && maps[sRow].charAt(sCol + 1) != 'X') {
                visited[sRow][sCol + 1] = true;
                queue.offer(new Coordinate(sRow, sCol + 1, cnt + 1));
            }
        }
        if (!findL) return -1;
        
        boolean findE = false;
        while (!queue.isEmpty()) { // 출구 찾기
            Coordinate cur = queue.poll();
            int sRow = cur.getRow();
            int sCol = cur.getCol();
            int cnt = cur.getCnt();
            visited[sRow][sCol] = true;
            if (maps[sRow].charAt(sCol) == 'E') {
                findE = true;
                answer = cnt;
                break;
            }
            if (sRow - 1 >= 0 && !visited[sRow - 1][sCol] && maps[sRow - 1].charAt(sCol) != 'X') {
                visited[sRow - 1][sCol] = true;
                queue.offer(new Coordinate(sRow - 1, sCol, cnt + 1));
            }
            if (sRow + 1 < row && !visited[sRow + 1][sCol] && maps[sRow + 1].charAt(sCol) != 'X') {
                visited[sRow + 1][sCol] = true;
                queue.offer(new Coordinate(sRow + 1, sCol, cnt + 1));
            }
            if (sCol - 1 >= 0 && !visited[sRow][sCol - 1] && maps[sRow].charAt(sCol - 1) != 'X') {
                visited[sRow][sCol - 1] = true;
                queue.offer(new Coordinate(sRow, sCol - 1, cnt + 1));
            }          
            if (sCol + 1 < col && !visited[sRow][sCol + 1] && maps[sRow].charAt(sCol + 1) != 'X') {
                visited[sRow][sCol + 1] = true;
                queue.offer(new Coordinate(sRow, sCol + 1, cnt + 1));
            }
        }
        if (!findE) return -1;
        
        return answer;
    }
}