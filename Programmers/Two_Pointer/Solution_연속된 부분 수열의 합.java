class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = { 0, Integer.MAX_VALUE };
        int start = 0, end, sum = 0;
        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            end = i;
            if (sum == k && (answer[1] - answer[0]) > end - start) {
                answer[0] = start;
                answer[1] = end;
            }
            if (sum > k) {
                while (sum > k) {
                    sum -= sequence[start++];
                }
                if (sum == k && (answer[1] - answer[0]) > end - start) {
                    answer[0] = start;
                    answer[1] = end;
                }
            }
        }
        
        return answer;
    }
}