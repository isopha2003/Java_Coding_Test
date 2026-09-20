class Solution {
    public String solution(String number, int k) {
        int max = 0;
        int idx = 0;
        for (int i = 0; i <= k; i++) {
            int n = number.charAt(i) - '0';
            if (max < n) {
                max = n;
                idx = i;
            }
        }
        k -= idx;
        if (k == 0) return number.substring(idx);
        
        StringBuilder sb = new StringBuilder(number.substring(idx));
        for (int i = 0; i < sb.length() - 1; i++) {
        int a = sb.charAt(i) - '0';
        int b = sb.charAt(i + 1) - '0';
            if (k > 0 && a < b) { // 현재 자리보다 뒤에 있는 수가 더 클 경우 없애기
                k--;
                sb.deleteCharAt(i);
                i = 0;
            }
        }
        if (k == 0) return sb.toString();
        return sb.substring(0, sb.length() - k).toString();
    }
}