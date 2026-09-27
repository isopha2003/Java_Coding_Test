class Solution {
    private String[] alpha = new String[]{"A", "E", "I", "O", "U"};
    private String word;
    private int cnt = 0;
    private boolean isFind = false;
    private void dfs(StringBuilder sb) {
        if (sb.toString().equals(word)) {
            isFind = true;
            return;
        }
        if (sb.length() >= 5) {
            return;
        }
        for (int i = 0; i < alpha.length; i++) {
            if (!isFind) {
                cnt++;
                dfs(sb.append(alpha[i]));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    
    public int solution(String word) {
        StringBuilder sb = new StringBuilder("");
        this.word = word;
        dfs(sb);
        
        return cnt; 
    }
    
}