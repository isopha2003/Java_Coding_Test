import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
class Solution {
    public int setRight(Set<Integer> set, int n) {
        for (int i = n; i >= 0; i++) {
            if (set.contains(i) == false) {
                return i;
            }
        }
        return 0;
    }
    public int solution(int[] people, int limit) {
        int answer = 0;
        int boat = 0;
        int limitIndex = people.length;
        Arrays.sort(people); // 오름차순 정렬
        // limit 보다 높은 무게를 가진 사람은 미리 보트에 태우기
        for (int i = 0; i < people.length; i++) {
            if (people[i] >= limit) {
                boat += people.length - i;
                limitIndex = i;
                break;
            }
        }
        int left = 0;
        int right = limitIndex - 1;
        int remain = limitIndex;
        Set<Integer> set = new HashSet<>();
        while(true) {
            if (remain == 0) {
                break;
            }
            if (left == right) {
                set.add(right);
                boat++;
                remain -= 1;
                left++;
                right = setRight(set, limitIndex - 1);
            }
            else if (people[left] + people[right] <= limit) {
                set.add(right);
                boat++;
                remain -= 2;
                left++;
                right = setRight(set, limitIndex - 1);
            }
            else {
                right--;
            }
        }
        return boat;
    }
}