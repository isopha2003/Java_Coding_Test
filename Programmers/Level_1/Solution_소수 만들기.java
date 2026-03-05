class Solution {
    public int solution(int[] nums) {
        int answer = -1;
        int n; // 세 수를 더한 수
        int cnt = 0; // 소수가 나오는 경우의 수
        boolean isPrime = true; // 소수인지 판별
        
        // 세 수를 더하는 모든 경우의 수
        for (int i = 0; i < nums.length - 2; i++) {
            
            for (int j = i + 1; j < nums.length - 1; j++) { 
                
                for (int s = j + 1; s < nums.length; s++) {
                    isPrime = true;
                    n = 0;
                    n = nums[i] + nums[j] + nums[s];
                    
                    // 소수인지 판별
                    for (int k = 2; k <= n / 2; k++) {
                        if (n % k == 0) {
                            isPrime = false; // 소수가 아님
                            break; // 소수가 아니라면 종료
                        }
                    }
                    // 소수가 나왔다면 경우의 수 증가
                    if (isPrime == true) {
                        cnt++;
                    }
                }
            }
        }
        
        answer = cnt;

        return answer;
    }
}