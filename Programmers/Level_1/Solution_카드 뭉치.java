class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        boolean find = false;
        int index1 = 0; // cards1의 인덱스
        int index2 = 0; // cards2의 인덱스
        for (int i = 0; i < goal.length; i++) {
            find = false;
            if (cards1[index1].equals(goal[i])) {
                find = true;
                index1++;
                if (index1 >= cards1.length) {
                    index1 = cards1.length - 1;
                }
            }
            else if (cards2[index2].equals(goal[i])) { 
                find = true;
                index2++;
                if (index2 >= cards2.length) { 
                    index2 = cards2.length - 1;
                }
            }
            if (find == false) {
                answer = "No";
                break;
            }
        }
        if (find == true) { 
            answer = "Yes";
        }
        return answer;
    }
}