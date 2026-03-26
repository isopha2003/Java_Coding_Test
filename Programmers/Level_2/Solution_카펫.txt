class Solution {
    public int calculate(int w, int h) {
        return (w * h);
    }
    public int[] solution(int brown, int yellow) {
        int w, h;
        int [] answer = new int[2];
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                w = yellow / i;
                h = i;
                while(true) {
                    w += 2;
                    h += 2;
                    if (calculate(w, h) == brown + yellow) {
                        answer[0] = w;
                        answer[1] = h;
                        return answer;
                    }
                    else if (calculate(w, h) > brown + yellow) {
                        break;
                    }
                }
            }
        }
        return answer;
    }
}