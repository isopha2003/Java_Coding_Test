class Solution {
    public int solution(int n) {
        int answer;
        int countNOne = Integer.bitCount(n);
        int nextN = n + 1;
        while(true) {
            if (Integer.bitCount(nextN) == countNOne) {
                answer = nextN;
                break;
            }
            nextN++;
        }
        return answer;
    }
}