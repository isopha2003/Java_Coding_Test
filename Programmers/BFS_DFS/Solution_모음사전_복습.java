class Solution {
    private String[] alphabet = { "A", "E", "I", "O", "U" };
    private int ans = 0;
    private int cnt = 0;
    public int solution(String word) {
        dfs("", word);
        
        return ans;
    }
    private void dfs(String s, String word) {
        if (s.length() == 5) {
            return;
        }
        for (int i = 0; i < alphabet.length; i++) {
            cnt++;
            if ((s + alphabet[i]).equals(word)) {
                ans = cnt;
                return;
            }
            dfs(s + alphabet[i], word);
        }
    }
}