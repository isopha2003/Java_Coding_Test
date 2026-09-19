class Solution {    
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        int player = 0;
        int round = 1;
        
        for (int i = 1; i < words.length; i++) {
            player = i % n + 1;
            if (player == 1) {
                round++;
            }
            char last = words[i - 1].charAt(words[i - 1].length() - 1);
            char first = words[i].charAt(0);
            if (last != first) {
                answer = new int[]{player, round};
                return answer;
            }
            for (int j = 0; j < i; j++) {
                if (words[i].equals(words[j])) {
                    answer = new int[]{player, round};
                    return answer;
                }
            }
        }
        answer = new int[]{0, 0};
        return answer;
    }
}