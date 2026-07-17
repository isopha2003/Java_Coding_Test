import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        int back = people.length - 1;
        Arrays.sort(people); // 오름차순 정렬
        
        for (int front = 0; front < people.length; front++) {
            if (people[front] == -1) {
                continue;
            }
            if (people[front] == limit) {
                boat++;
                continue;
            }
            while(true) {
                if (front >= back) {
                    people[front] = -1;
                    boat += ;
                    break;
                }
                if (people[front] + people[back] <= limit && people[back] != -1) {
                    people[front] = -1;
                    people[back] = -1;
                    boat++;
                    break;
                }
                back--;
            }
        }
        return boat;
    }
}