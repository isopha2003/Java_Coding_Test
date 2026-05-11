import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int find = commands[i][2] - 1;
            int[] result = Arrays.copyOfRange(array, start, end); // 배열 나누기
            Arrays.sort(result); // 오름차순 정렬
            list.add(result[find]);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}