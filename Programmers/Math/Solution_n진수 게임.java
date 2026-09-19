class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int index = 0;
        int order = 1; // 전체 순서
        int currentOrder = 1; // 현재 순서
        int count = 0; // 현재 구한 숫자의 개수
        while(true) {
            if (count >= t) {
                break;
            }
            String str = Integer.toString(index, n).toUpperCase(); // n진수 변환
            for (int i = 0; i < str.length(); i++) {
                if (currentOrder == p) {
                    answer += str.charAt(i);
                    count++;
                    if (count >= t) {
                        break;
                    }
                }
                currentOrder = order % m + 1;
                order++;
            }
            index++;
        }
        return answer;
    }
}