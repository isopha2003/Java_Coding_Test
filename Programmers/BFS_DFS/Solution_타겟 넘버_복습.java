class Solution {
    private boolean[] visited;
    private int result = 0;
    public void dfs(int[] numbers, int sum, int target) {
        if (sum == target) {
            result++;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(numbers, sum + numbers[i], target);
            dfs(numbers, sum - numbers[i], target);
        }
    }
    public int solution(int[] numbers, int target) {
        int len = numbers.length;
        visited = new boolean[len];
        dfs(numbers, 0, target);
        
        return result;
    }
}