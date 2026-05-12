import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        int len = numbers.length;
        String[] arr = new String[len];
        
        for (int i = 0; i < len; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));    
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < len; i++) {
            sb.append(arr[i]);
        }
        
        if (sb.toString().startsWith("0")) {
            return "0";
        }
        
        return sb.toString();
    }
}