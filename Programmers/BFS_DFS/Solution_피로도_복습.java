class Solution {
    boolean[] visited;
    int result = 0;
    public void dfs(int k, int[][] dungeons, int cnt) {
        result = Math.max(result, cnt);
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || dungeons[i][0] > k) {
                continue;
            }
            visited[i] = true;
            dfs(k - dungeons[i][1], dungeons, cnt + 1);
            visited[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, result);
        
        return result;
    }
}