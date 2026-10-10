class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        int idx = 0;
        long[] result = new long[len];
        for (int i = 0; i < len; i++) {
            long n = numbers[i];
            if (n % 2 == 0) {
                result[idx++] = n | 1;
            } else {
                boolean findZero = false;
                String s = Long.toString(n, 2);
                for (int j = s.length() - 1; j >= 0; j--) {
                    char c = s.charAt(j);
                    if (c == '0') {
                        findZero = true;
                        s = s.substring(0, j) + "10" + s.substring(j + 2);
                        result[idx++] = Long.parseLong(s, 2);
                        break;
                    }
                }
                if (!findZero) {
                    s = "10" + s.substring(1);
                    result[idx++] = Long.parseLong(s, 2);
                }
            }
        }
        return result;
    }
}