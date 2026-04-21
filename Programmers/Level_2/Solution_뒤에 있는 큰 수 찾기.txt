class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int index = 0;
        boolean isExist = false;
        for (int i = 0; i < numbers.length; i++) {
            isExist = false;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] > numbers[i]) {
                    isExist = true;
                    answer[index++] = numbers[j];
                    break;
                }
            }
            if(!isExist) {
                answer[index++] = -1;
            }
        }
        return answer;
    }
}