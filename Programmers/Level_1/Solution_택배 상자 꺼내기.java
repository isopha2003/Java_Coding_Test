class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int line = 0;
        int order = 1;
        // num이 밑에서부터 몇번째 줄에 있는지 확인
        for (int i = 1; i <= n; i++) {
            if (i % w == 0) {
                line++;
            }
            if (i == num) {
                break;
            }
        }
        if (line == 0) {
            line = 1;
        }
        // 몇번째에 위치해있는지 찾기
        // 홀수 라인일 때
        if (line % 2 != 0) {
            order = num % w;
            if (order == 0) {
                order = w;
            }
        }
        // 짝수 라인일 때
        else {
            order = line * w - num + 1;
        }
        while(true) {
            if (num > n) {
                break;
            }
            // 짝수 라인일 때
            if (line % 2 == 0) {
                num += 2 * order - 1;
                line++;
                answer++;
            }
            // 홀수 라인일 때
            else {
                num += (w - order) * 2 + 1;
                line++;
                answer++;
            }
        }
        return answer;
    }
}