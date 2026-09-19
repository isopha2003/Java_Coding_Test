import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int jaccard(List<String> arr1, List<String> arr2) {
        int arr1Len = arr1.size();
        int arr2Len = arr2.size();
        int count = 0;
        boolean contains;
        for (int i = 0; i < arr1Len; i++) {
            String str1 = arr1.get(i);
            contains = arr2.contains(str1);
            if (contains) {
                arr2.remove(str1);
                count++;
            }
        }
        if (arr1Len == 0 && arr2Len == 0) {
            return 65536;
        }
        return (int) ((double) count / (arr1Len + arr2Len - count) * 65536);
    }
    // 문자열을 2개씩 끊어서 배열에 저장
    public void divideArr(String string, List<String> arr1) {
        char c = 'a';
        String str = "";
        int index = 0;
        boolean isAlpha;
        while(true) {
            if (index >= string.length()) {
                break;
            }
            c = string.charAt(index++);
            if (Character.isLetter(c)) {
                str += c;
                if (str.length() == 2) {
                    arr1.add(str);
                    str = "";
                    str += c;
                }
            }
            else {
                str = "";
            }
        }
    }
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        
        // 대문자 변경 후 공백 제거
        str1 = str1.toUpperCase().trim(); 
        str2 = str2.toUpperCase().trim();
        
        divideArr(str1, arr1);
        divideArr(str2, arr2);
        
        answer = jaccard(arr1, arr2);
        
        return answer;
    }
}