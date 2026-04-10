import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        int count = 0;
        while(true) {
            count = 0;
            boolean isFin = false;
            if (index >= progresses.length) {
                break;
            }
            for (int i = index; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            while(true) {
                if (index >= progresses.length) {
                    list.add(count);
                    break;
                }
                if (progresses[index] < 100) {
                    if (isFin == true) {
                        list.add(count);
                    }
                    break;
                }
                else {
                    isFin = true;
                    index++;
                    count++;
                }
            }
        }
        int answer[] = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}