import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        // 학생 1, 2, 3의 찍기 번호        
        
        int score1 = 0, score2 = 0, score3 = 0; // 학생 1, 2, 3의 점수
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < answers.length; i++) {
            if (answer1[i % 5] == answers[i]) score1++;
            if (answer2[i % 8] == answers[i]) score2++;
            if (answer3[i % 10] == answers[i]) score3++;
        }
        
        int max = Math.max(score1, Math.max(score2, score3));
        if (max == score1) list.add(1);
        if (max == score2) list.add(2);
        if (max == score3) list.add(3);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}