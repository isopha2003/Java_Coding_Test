import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] orders) {
        Deque<Integer> container = new ArrayDeque<>();
        Deque<int[]> subContainer = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < orders.length; i++) {
            subContainer.push(new int[]{i + 1, orders[i]});
            while(true) {
                if (subContainer.peek() != null && orders[index] == subContainer.peek()[0]) {
                    container.push(subContainer.pop()[1]);
                    index++;
                }
                else {
                    break;
                }
            }
        }
        while(!subContainer.isEmpty()) {
            if (subContainer.peek()[0] == orders[index]) {
                container.push(subContainer.pop()[1]);
                index++;
            }
            else {
                break;
            }
        }
        return container.size();
    }
}