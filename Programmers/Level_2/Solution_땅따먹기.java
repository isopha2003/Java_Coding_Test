class Solution {
    private int answer = 0;
    public void route(int[][] land, int col, int sum, int before) {
        if (col >= land.length) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < land[0].length; i++) {
            if (i == before) {
                continue;
            }
            else {
                route(land, col + 1, sum + land[col][i], i);
            }
        }
    }
    int solution(int[][] land) {
        route(land, 0, 0, -1);

        return answer;
    }
}