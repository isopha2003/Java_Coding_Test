import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            if (map.size() >= len / 2) {
                break;
            }    
            Integer mon = map.get(nums[i]);
            if (mon == null) { // 해시맵에 해당 포켓몬이 존재하지 않을 때
                map.put(nums[i], 1);
            }
            else {
                continue;
            }
        }
        
        return map.size();
    }
}