import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> factors = new ArrayList<>();
        List<Integer> deleteFactors = new ArrayList<>();
        
        Arrays.sort(arrayA);
        factors = getFactor(arrayA[0]);
        for (int i = 0; i < factors.size(); i++) { // 본인이 가진 카드를 전부 나눌 수 있는지 확인
            int factor = factors.get(i);
            for (int j = 0; j < arrayA.length; j++) {
                if (arrayA[j] % factor != 0) {
                    deleteFactors.add(factor);
                    break;
                }
            }
        }
        for (int d : deleteFactors) { // 나누지 못한 수 삭제
            factors.remove(Integer.valueOf(d));
        }
        deleteFactors.clear();
        
        int answerA = 0;
        for (int i = 0; i < factors.size(); i++) {
            boolean isDivided = false;
            int factor = factors.get(i);
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayB[j] % factor == 0) {
                    isDivided = true;
                    break;
                }
            }
            if (!isDivided) answerA = factor;
        }
        
        Arrays.sort(arrayB);
        factors = getFactor(arrayB[0]);
        for (int i = 0; i < factors.size(); i++) {
            int factor = factors.get(i);
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayB[j] % factor != 0) {
                    deleteFactors.add(factor);
                    break;
                }
            }
        }
        for (int d : deleteFactors) {
            factors.remove(Integer.valueOf(d));
        }
        
        int answerB = 0;
        for (int i = 0; i < factors.size(); i++) {
            boolean isDivided = false;
            int factor = factors.get(i);
            for (int j = 0; j < arrayA.length; j++) {
                if (arrayA[j] % factor == 0) {
                    isDivided = true;
                    break;
                }
            }
            if (!isDivided) answerB = factor;
        }
        
        return Math.max(answerA, answerB);
    }
    private List<Integer> getFactor(int n) { // 1을 제외한 약수를 리턴하는 배열
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
}