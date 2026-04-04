class Solution {
    public int[] solution(int n, long left, long right) {
        int arr[] = new int[n * n];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= i) {
                    arr[index++] = i;
                }
                else {
                    arr[index++] = j;
                }
            }
        }
        int answer[] = new int[(int)right - (int)left + 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr[(int)left++];
        }
        return answer;
    }
}
