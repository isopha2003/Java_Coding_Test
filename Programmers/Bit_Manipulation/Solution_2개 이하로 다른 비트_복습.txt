class Solution {
    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];
        int idx = 0;
        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            long n2 = n;
            
            int cnt = 0;
            boolean find = true;
            while(true) {
                find = true;
                cnt = 0;
                n2++;
                String b2 = Long.toBinaryString(n2); // 2진수
                String b1 = String.format("%" + b2.length() + "s", Long.toBinaryString(n)).replace(' ', '0');
                for (int j = 0; j < b2.length(); j++) {
                    char c1;
                    try {
                        c1 = b1.charAt(j);
                    } catch (StringIndexOutOfBoundsException e) {
                        c1 = '0';
                    }
                    char c2 = b2.charAt(j);
                    
                    if (c1 != c2) {
                        cnt++;
                        if (cnt > 2) {
                            find = false;
                            break;
                        }
                    }
                }
                if (find) {
                    result[idx++] = n2;
                    break;
                }
            }
        }
        return result;
    }
}