class Solution {
    public int solution(int[][] info, int n, int m) {
        int total = info.length;
        int countA = 0;
        int countB = 0;

        // 정렬 루프
        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                double efficiencyI = (double)info[i][0] / info[i][1];
                double efficiencyJ = (double)info[j][0] / info[j][1];
                if (efficiencyI < efficiencyJ) {
                    int[] temp = info[i];
                    info[i] = info[j];
                    info[j] = temp;
                }
            }
        }

        // 물건 배분 루프
        for (int i = 0; i < total; i++) {
            if (countB + info[i][1] < m) { // B가 가져갈 수 있으면
                countB += info[i][1];
            } else { // 못 가져가면 A가 가져감
                countA += info[i][0];
            }
        }

        return (countA < n) ? countA : -1;
    }
}