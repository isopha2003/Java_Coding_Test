class Solution {
    private boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        int limit = (int)Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int solution(int n, int k) {        
        int cnt = 0;
        String baseK = Integer.toString(n, k);           
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < baseK.length(); i++) {
            char c = baseK.charAt(i);
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
        }
        return cnt;
    }
}