class Solution {
    public int solution(int storey) {
        int result = 0;
        int dividend = 1;
        int digit = 0;
        
        while(true) { // storey가 몇자리수인지 계산
            if (storey / dividend == 0) {
                break;
            }
            dividend *= 10;
            digit++;
        }
        
        dividend = (int)Math.round(Math.pow(10, digit - 1));
        int[] digits = new int[digit];
        for (int i = 0; i < digit; i++) {
            digits[i] = storey / dividend;
            storey = storey % dividend;
            dividend /= 10;
        }
        
        for (int i = digit - 1; i >= 0; i--) {
            if (digits[i] > 5) {
                if (i == 0) {
                    result = result + 10 - digits[i] + 1;
                }
                else {
                    digits[i - 1] += 1;
                    result = result + 10 - digits[i];
                }
            }
            else if (digits[i] == 5 && i != 0) {
                if (digits[i - 1] > 5) {
                    digits[i - 1] += 1;
                    result = result + 10 - digits[i];
                }
                else {
                    result = result + digits[i];
                }
            }
            else {
                result = result + digits[i];
            }
        }
        
        return result;
    }
}