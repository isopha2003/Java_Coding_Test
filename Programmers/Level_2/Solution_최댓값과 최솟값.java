import java.util.IntSummaryStatistics;
import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = "";
        IntSummaryStatistics stats = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
        int min = stats.getMin();
        int max = stats.getMax(); 
        answer = Integer.toString(min) + " " + Integer.toString(max);
        return answer;
    }
}