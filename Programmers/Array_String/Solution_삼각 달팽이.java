class Solution {
    private int factorial(int n) {
        int sum = 0;
        for (int i = n; i >= 1; i--) {
            sum += i;
        }
        return sum;
    }
    public int[] solution(int n) {
        int idx = 0;
        int order = 1;
        int[] answer = new int[factorial(n)];
        int pattern = 0;
        int pattern1 = 0;
        int pattern3 = n;
        
        for (int i = n; i >= 1; i--) {
            pattern = (pattern % 3) + 1; // 1, 2, 3의 패턴
            int tmp = 0;
            if (pattern == 1) { 
                tmp = pattern1;
            } else if (pattern == 3) {
                tmp = pattern3;
            }
            for (int j = i; j >= 1; j--) {
                switch (pattern) {
                    case 1: {
                        idx = idx + tmp++;
                        answer[idx] = order++;
                        break;
                    }
                    case 2: {
                        idx = idx + 1;
                        answer[idx] = order++;
                        break;
                    }
                    case 3: {
                        idx = idx - tmp--;
                        answer[idx] = order++;
                        break;
                    }
                }
            }
            if (pattern == 1) {
                pattern1 += 2;
            } else if (pattern == 3) {
                pattern3--;
            }
        }
        return answer;
    }
}