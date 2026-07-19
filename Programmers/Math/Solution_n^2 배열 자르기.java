class Solution {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int)(right - left) + 1];

        int share = (int)(left / n);
        int remain = (int)(left % n);
        
        for (int i = 0; i < (int)(right - left) + 1; i++) {
            result[i] = Math.max(share, remain) + 1;
            if (remain == n - 1) {
                share++;
                remain = 0;
            }
            else {
                remain++;
            }
        }
        return result;
    }
}