import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        char skill_order[] = new char[skill.length()];
        
        for (int i = 0; i < skill.length(); i++) {
            set.add(skill.charAt(i));
        }
        
        for (int i = 0; i < skill_trees.length; i++) {
            int index = 0;
            boolean isPossible = true;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                char c = skill_trees[i].charAt(j);
                if (set.contains(c)) { // 스킬 트리에 존재하는 스킬인 경우
                    if (skill.charAt(index) == c) { // 현재 배우는 것이 가능할 때
                        index++;
                    }
                    else { // 현재 배우는 것이 불가능할 
                        isPossible = false;
                        break;
                    }
                }
            }
            if (isPossible) {
                count++;
            }
        }
        return count;
    }
}