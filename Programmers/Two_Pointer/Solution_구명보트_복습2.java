import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        Arrays.sort(people);
        int tail = people.length - 1;
        for (int i = 0; i < people.length; i++) {
            if (i > tail) {
                break;
            }
            while(true) {
                if (i > tail) {
                    break;
                }
                if (people[i] + people[tail] <= limit) {
                    tail--;
                    boat++;
                    break;
                }
                tail--;
                boat++;
            }
        }
        return boat;
    }
}