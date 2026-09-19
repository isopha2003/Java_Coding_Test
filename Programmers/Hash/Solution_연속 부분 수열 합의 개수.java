import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < i + n; j++) { // 전체 길이 미만까지
                sum += elements[j % n]; // 나머지 연산으로 원형 구현
                set.add(sum);
            }
        }
        return set.size();
    }
}