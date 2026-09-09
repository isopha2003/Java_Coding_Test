import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Set<Character> set = new HashSet<>(); 
        char[] order = new char[skill.length()];
        int idx = 0;
        int cnt = 0;
        boolean isPossible = true;
        
        for (int i = 0; i < skill.length(); i++) { // 스킬트리가 존재하는 스킬을 저장
            char s = skill.charAt(i);
            set.add(s);
            order[i] = s; 
        }
        
        for (int i = 0; i < skill_trees.length; i++) {
            idx = 0;
            isPossible = true;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                char s = skill_trees[i].charAt(j);
                if (set.contains(s)) { // 현재 배우려는 스킬이 선행 스킬을 요구할 때
                    if (order[idx] == s) { // 현재 배울 수 있는 스킬일 때
                        idx++;
                    }
                    else {
                        isPossible = false;
                        break;
                    }
                }
            }
            if (isPossible) {
                cnt++;
            }
        }
        
        return cnt;
    }
}