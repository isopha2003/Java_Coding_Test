class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        int order = 1;
        while(sb.length() < t) {
            String number = Integer.toString(idx, n);
            number = number.toUpperCase();
            for (int i = 0; i < number.length(); i++) {
                if (order == p) {
                    sb.append(number.charAt(i));
                    if (sb.length() == t) {
                        break;
                    }
                }
                order = order % m + 1;
            }
            idx++;
        }
        
        return sb.toString();
    }
}