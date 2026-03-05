class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        int degreeA = 1;
        int degreeB = 1;

        int i = 2;
        // a가 속한 범위의 차수 구하기
        while(true) {
            if (a == 1) {
                degreeA = 0;
                break;
            }
            if (i >= a) {
                break;
            }
            i *= 2;
            degreeA++;
        }
        // b가 속한 범위의 차수 구하기
        i = 2;
        while(true) {
            if (b == 1) {
                degreeB = 0;
                break;
            }
            if (i >= b) {
                break;
            }
            i *= 2;
            degreeB++;
        }
        if (degreeA > degreeB) {
            answer = degreeA;
            return answer;
        }
        else if (degreeA < degreeB) {
            answer = degreeB;
            return answer;
        }
        else {
            n /= 2;
            a %= n;
            if (a == 0) {
                a = n;
            }
            b %= n;
            if (b == 0) {
                b = n;
            }
            return solution(n, a, b);
        }
    }
}
