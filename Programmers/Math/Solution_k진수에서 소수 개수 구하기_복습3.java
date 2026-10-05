class Solution {
    public boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int solution(int n, int k) {
        int cnt = 0;
        String s = Integer.toString(n, k); // n을 k진수로 변환
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (!sb.isEmpty() && isPrime(Long.parseLong(sb.toString()))) {
                    cnt++;
                }
                sb.setLength(0);
            }
            else {
                sb.append(c);
            }
        }
        if (!sb.isEmpty() && isPrime(Long.parseLong(sb.toString()))) {
            cnt++;
            sb.setLength(0);
        }
        return cnt;
    }
}