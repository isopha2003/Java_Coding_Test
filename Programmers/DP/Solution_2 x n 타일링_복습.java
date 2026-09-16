class Solution {
    public int solution(int n) {
        int[] fibo = new int[n + 2];
        
        fibo[1] = 1;
        fibo[2] = 1;
        
        for (int i = 3; i <= n + 1; i++) {
            fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 1000000007;
        }
        return fibo[n + 1];
    }
}