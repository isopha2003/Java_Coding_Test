class Solution {
    private int answer = -1;
    private boolean[][] visited;
    private int row;
    private int col;
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        row = maps.length;
        col = maps[0].length;
        
        dfs(maps, 1, 0, 0);
        
        return answer;
    }
    public void dfs(int[][] maps, int count, int x, int y) {
        visited[x][y] = true;
        if (x + 1 < row && !visited[x + 1][y] && maps[x + 1][y] != 0) {
            dfs(maps, count + 1, x + 1, y);
        }
        if (x - 1 >= 0 && !visited[x - 1][y] && maps[x - 1][y] != 0) {
            dfs(maps, count + 1, x - 1, y);
        }
        if (y + 1 < col && !visited[x][y + 1] && maps[x][y + 1] != 0) {
            dfs(maps, count + 1, x, y + 1);
        }
        if (y - 1 >= 0 && !visited[x][y - 1] && maps[x][y - 1] != 0) {
            dfs(maps, count + 1, x, y - 1);
        }
        visited[x][y] = false;
        if (x == row - 1 && y == col - 1) {
            if (answer > count || answer == -1) {
                answer = count;
            }
        }        
    }
}