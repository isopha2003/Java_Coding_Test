import java.util.Arrays;

class Solution {
    public int solution(int[] priorities, int location) {
        int maxIdx = 0;
        int len = priorities.length;
        for (int i = 1; i < len; i++) {
            if (priorities[maxIdx] < priorities[i]) {
                maxIdx = i;
            }
        }
        int order = 1;
        int idx = maxIdx;
        while(true) {
            while(true) {
                int p = priorities[idx];
                boolean isExist = Arrays.stream(priorities).anyMatch(a -> a > p);
                if (!isExist) {
                    priorities[idx] = -1;
                    break;
                }
                idx = (idx + 1) % len;
            }
            if (idx == location) {
                break;
            }
            idx = (idx + 1) % len;
            order++;
        }
        return order;
    }
}