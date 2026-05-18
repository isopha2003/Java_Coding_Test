import java.util.Set;
import java.util.HashSet;

class Solution {
    private Set<Integer> set = new HashSet<>(); // 소수를 저장할 해시
    private boolean[] visited;
    private int len;
    
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public void dfs(String numbers, StringBuilder sb) {
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(numbers.charAt(i));
                int n = Integer.parseInt(sb.toString());
                if (isPrime(n)) { // 소수일 때
                    set.add(n);
                }
                dfs(numbers, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        StringBuilder sb = new StringBuilder();
        len = numbers.length();
        
        visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            visited[i] = false;
        }
        
        dfs(numbers, sb);
        
        return set.size();
    }
}