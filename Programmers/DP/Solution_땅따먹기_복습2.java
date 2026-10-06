class Solution {
    int solution(int[][] land) {
        int[] sum = new int[land[0].length];
        for (int i = 0; i < 4; i++) {
            sum[i] = land[0][i];
        }
        
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int max = 0;
                for (int k = 0; k < land[i].length; k++) {
                    if (j == k) {
                        continue;
                    }
                    max = Math.max(max, land[i][j] + sum[k]);
                }
                sum[j] = max;
            }
        }
        int answer = 0;
        for (int i = 0; i < sum.length; i++) {
            answer = Math.max(answer, sum[i]);
        }
        return answer;
    }
}