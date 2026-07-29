import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        int result = 0;
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        
        for (int i = 0; i < topping.length; i++) {
            Integer t = topping[i];
            right.put(t, right.getOrDefault(t, 0) + 1);
        }
        for (int i = 0; i < topping.length; i++) {
            Integer t = topping[i];
            left.put(t, left.getOrDefault(t, 0) + 1);
            right.put(t, right.get(t) - 1);
            if (right.get(t) <= 0) {
                right.remove(t);
            }
            if (left.size() == right.size()) {
                result++;
            }
        }
        return result;
    }
}