import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        Map<Integer, int[]> map = new TreeMap<>();
        String str = "";
        
        // 각 원소의 길이별로 트리맵에 저장 및 자동 정렬
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{') {
                continue;
            }
            else if (c == '}') {
                if (!str.isEmpty()) {
                    int[] arr = Arrays.stream(str.split(",")).filter(x -> !x.isEmpty()).mapToInt(Integer::parseInt).toArray();
                    map.put(arr.length, arr);
                    str = "";
                }
            }
            else {
                str += c;
            }
        }
        int[] answer = new int[map.size()];
        int index = 0;
        for (int[] arr : map.values()) {
            for (int i = 0; i < arr.length; i++) {
                int val = arr[i];
                boolean contains = Arrays.stream(answer).anyMatch(x -> x == val);
                if (contains == true) {
                    continue;
                }
                else {
                    answer[index++] = arr[i];   
                }
            }
        }
        
        return answer;
    }
}