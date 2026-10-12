class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 2];
        for (int stolen : lost) {
            students[stolen]--;
        }
        for (int spare : reserve) {
            students[spare]++;
        }
        for (int i = 1; i < students.length; i++) {
            if (students[i] == -1) {
                if (students[i - 1] == 1) {
                    students[i - 1]--;
                    students[i]++;
                } else if (students[i + 1] == 1) {
                    students[i + 1]--;
                    students[i]++;
                }
            }
        }
        for (int i = 1; i < students.length; i++) {
            if (students[i] == -1) {
                n--;
            }
        }
        return n;
    }
}