class Solution {
    private int answer = 0;
    private int target;
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        this.target = target;
        dfs(numbers, 0, 0);
        
        return answer;
    }
    public void dfs(int[] numbers, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, index + 1, sum + numbers[index]);
        dfs(numbers, index + 1, sum - numbers[index]);
    }
}