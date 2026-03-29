import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            Integer n = map.get(tangerine[i]);
            if (n == null) {
                map.put(tangerine[i], 1);
            }
            else {
                map.put(tangerine[i], ++n);
            }
        }
        Integer arr[] = map.values().toArray(new Integer[0]);
        // map.values()는 Collections<Integer>를 반환하기 때문에
        // 제네릭은 primitive 타입을 지원하지 않으므로 
        // 래퍼 클래스인 Integer를 사용해야 함
        // new Integer[0]는 toArray를 할 때 반환할 배열의 타입을 명시하는 것으로, 
        // 크기를 0으로 줘도 실제 크기게 맞게 배열을 생성함
        Arrays.sort(arr, Collections.reverseOrder());
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            answer++;
            if (sum >= k) {
                break;
            }
        }
        
        return answer;
    }
}