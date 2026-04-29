import java.util.List;
import java.util.ArrayList;

class Solution {
    private String str = "";
    private List<Long> list = new ArrayList<>();
    public void baseK(int num, int k) {
        if (num == 0) {
            return;
        }
        baseK(num / k, k);
        if ((num % k) == 0) { // str이 비어있지 않고, num % k == 0일 때 저장
            if (!str.equals("")) {
                list.add(Long.parseLong(str));
                str = "";
            }
        }
        else { // str에는 0 저장하지 않음
            str += String.valueOf(num % k);
        }
    }
    public boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int solution(int n, int k) {
        int answer = 0;
        baseK(n, k);
        if (!str.equals("")) { // n이 비지 않았을 때
            list.add(Long.parseLong(str));
        }
        for (int i = 0; i < list.size(); i++) {
            if (isPrime(list.get(i))) {
                answer++;
            }
        }
        return answer;
    }
}