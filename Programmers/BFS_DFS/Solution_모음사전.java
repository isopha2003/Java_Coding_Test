import java.util.Map;
import java.util.HashMap;

class Solution {
    private String alpha[] = {"A", "E", "I", "O", "U"};
    private boolean[] visited = new boolean[alpha.length];
    private Map<Integer, String> map = new HashMap<>();
    private int answer = 0;
    private String word;
    private int index = 0;
    
    public int solution(String word) {
        this.word = word;
        dfs("", 0);
        
        return answer;
    }
    public void dfs(String str, int count) {
        for (int i = 0; i < alpha.length; i++) {
            if (count < 5 && !map.containsValue(str + alpha[i])) {
                map.put(index++, str + alpha[i]);
                if ((str + alpha[i]).equals(word)) {
                    answer = index;
                    return;
            }
                dfs(str + alpha[i], count + 1);
            }
        }
    }
}