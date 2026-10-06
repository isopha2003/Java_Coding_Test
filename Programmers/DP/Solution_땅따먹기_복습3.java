class Solution {
    int solution(int[][] land) {
        int[] cur = new int[land[0].length];
        for (int i = 0; i < land[0].length; i++) {
            cur[i] = land[0][i];
        }
        int[] prev = cur.clone();
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                for (int k = 0; k < land[i].length; k++) {
                    if (j == k) continue;
                    cur[j] = Math.max(cur[j], land[i][j] + prev[k]);
                }
            }
            prev = cur.clone();
        }
        int max = 0;
        for (int i = 0; i < cur.length; i++) {
            max = Math.max(max, cur[i]);
        }
        return max;
    }
}