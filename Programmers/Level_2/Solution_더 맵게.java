import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        List<Integer> list = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(ArrayList::new));
        list.sort(null); // 오름차순 정렬
        while(true) {
            if (list.size() < 2 && list.get(0) < K) {
                return -1;
            }
            if (list.get(0) >= K) {
                break;
            }
            int first = list.get(0);
            list.remove(0);
            int second = list.get(0);
            list.remove(0);
            int res = first + second * 2;
            list.add(res);
            list.sort(null);
            answer++;
        }
        return answer;
    }
}