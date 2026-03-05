class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        answer = new int[photo.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = 0;
        }       
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) { 
                String person = photo[i][j];
                for (int n = 0; n < name.length; n++) {
                    if (person.equals(name[n])) {
                        answer[i] += yearning[n];
                    }
                }
            }
        }
        return answer;
    }
}