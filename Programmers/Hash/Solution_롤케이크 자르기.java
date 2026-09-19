import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayDeque;


class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        int leftSize = 0;
        int rightSize = 0;
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap =new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            int t = topping[i];
            right.add(t);
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
            if (rightMap.get(t) == 1) {
                rightSize++;
            }
        }
        for (int i = 0; i < len; i++) {
            int t = right.poll();
            rightMap.put(t, rightMap.getOrDefault(t, 0) - 1);
            if (rightMap.get(t) == 0) {
                rightSize--;
            }
            
            left.add(t);
            leftMap.put(t, leftMap.getOrDefault(t, 0) + 1);
            if (leftMap.get(t) == 1) {
                leftSize++;
            }
            
            if (leftSize == rightSize) {
                answer++;
            }
        }
        
        return answer;
    }
}