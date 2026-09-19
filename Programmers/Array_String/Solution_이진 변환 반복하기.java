class Solution {
    public int[] solution(String s) {
        int countZero = 0;
        int len = s.length();
        int totalCountZero = 0;
        int countToBinary = 0;
        
        while(true) {
            len = s.length();
            countZero = 0;
            
            if (s.equals("1")) {
                break;
            }
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    countZero++;
                    totalCountZero++;
                }
            }
            len -= countZero;
            s = toBinary(len);
            countToBinary++;
        }
        int answer[] = {countToBinary, totalCountZero};
        return answer;
    }
    public String toBinary(int n) {
        String binaryArr = "";
        int dividend = n;
        while(true) {
            if (dividend == 0) {
                break;
            }
            binaryArr += dividend % 2;
            dividend /= 2;
        }
        return binaryArr;
    }
}