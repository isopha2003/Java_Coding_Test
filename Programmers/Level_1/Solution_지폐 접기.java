class Solution {
    public boolean compareSize(int[] wallet, int[] bill) {
        if ((wallet[0] >= bill[0] && wallet[1] >= bill[1]) || wallet[0] >= bill[1] && wallet[1] >= bill[0]) { 
            return true;
        }
        else {
            return false;
        }
    }
    public void fold(int[] bill) {
        if (bill[0] >= bill[1]) {
            bill[0] /= 2;
        }
        else {
            bill[1] /= 2;
        }
    }
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(true) {
            if(compareSize(wallet, bill)) {
                break;
            }
            fold(bill);
            answer++;
        }
        return answer;
    }
}