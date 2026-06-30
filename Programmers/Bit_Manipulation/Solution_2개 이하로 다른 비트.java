class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long result[] = new long[len];
        
        for (int i = 0; i < len; i++) {
            long n = numbers[i];
            long index = n + 1;
            
            while(true) {
                long diff = Long.bitCount(n ^ index);
                if (diff <= 2) {
                    result[i] = index;
                    break;
                }
                index++;
            }
        }
                
        return result;
    }
}