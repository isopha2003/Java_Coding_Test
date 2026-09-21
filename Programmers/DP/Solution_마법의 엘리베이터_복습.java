class Solution {
    public int solution(int storey) {
        int result = 0;
        while(true) {
            if (storey == 0) {
                break;
            }
            int remain = storey % 10;
            storey /= 10;
            if (remain > 5 || (remain >= 5 && storey % 10 >= 5)) {
                result = result + (10 - remain);
                storey++;
            } else {
                result += remain;
            }
        }
        
        return result;
    }
}