class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int limit; // 출근 제한 시간
        int[] success = new int[schedules.length];
        for (int i = 0; i < timelogs.length; i++) {
            limit = schedules[i] + 10;
            if (limit % 100 >= 60) {
                limit = (limit - limit % 100) + 100 + (limit % 100 - 60);
            }
            int day = startday;
            boolean flag = true;
            for (int j = 0; j < timelogs[i].length; j++) {
                if (timelogs[i][j] > limit && !(day == 6 || day == 7)) {
                    success[i] = 0;
                    flag = false;
                    break;
                }
                day++;
                if (day > 7) {
                    day = 1;
                }
            }
            if (flag == true) {
                success[i] = 1;
            }
        }
        // 성공한 인원 수 세기
        for (int i = 0; i < success.length; i++) {
            if (success[i] == 1) {
                answer++;    
            }
        }
        return answer;
    }
}