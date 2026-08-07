import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        int[] before = new int[2];
        int[] after = new int[2];
        int[] arr = new int[4];
        int[] reversedArr = new int[4];
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            before[0] = x;
            before[1] = y;
            char dir = dirs.charAt(i);
            
            switch(dir) {
                case 'L': {
                    x = (x > -5 ? x - 1 : -5);
                    break;
                }
                case 'R': {
                    x = (x < 5 ? x + 1 : 5);
                    break;
                }
                case 'U': {
                    y = (y < 5 ? y + 1 : 5);
                    break;
                }
                case 'D': {
                    y = (y > -5 ? y - 1 : -5);
                    break;
                }
            }
            after[0] = x;
            after[1] = y;
            arr[0] = before[0];
            arr[1] = before[1];
            arr[2] = after[0];
            arr[3] = after[1];
            
            reversedArr[0] = arr[2];
            reversedArr[1] = arr[3];
            reversedArr[2] = arr[0];
            reversedArr[3] = arr[1];
            
            if (arr[0] == arr[2] && arr[1] == arr[3]) { // 이동하지 않았을 때
                continue;
            }
            set.add(Arrays.toString(arr));
            set.add(Arrays.toString(reversedArr));
        }
        return set.size() / 2;
    }
}