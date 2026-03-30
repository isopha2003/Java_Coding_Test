class Solution {
    public int solution(int n) {
        int answer = 0;
        int a = 1, b = 2;
        if (n <= 3) {
                return n;
            }
        for (int i = 0; i < n - 2; i++) {
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }
        return answer;
    }
}