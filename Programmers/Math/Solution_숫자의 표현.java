class Solution {
    public int solution(int n) {
        int answer = 1;
        
        // 만약 자연수가 1일 때 
        if (n == 1) {
            return 1;
        }
        
        // 자연수 n의 절반 이상을 넘어가는 순간 더해도 초과하게 되므로
        // 더하는 수의 제한을 설정
        int limit;
        if (n % 2 == 0) {
            limit = n / 2;
        }
        else {
            limit = n / 2 + 1;
        }
        
        for (int i = 1; i <= limit; i++) {
            int sum = 0;
            for (int j = i; j <= limit; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }
                if (sum > n) {
                    break;
                }
            } 
        }
        return answer;
    }
}