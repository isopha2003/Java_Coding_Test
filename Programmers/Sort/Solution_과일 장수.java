import java.util.Arrays;
import java.util.Vector;
import java.util.Collections;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Vector<Integer> v = new Vector<Integer>();
        int cnt = 0;
        
        Arrays.sort(score); // 오름차순 정렬
        
        for (int i = score.length - 1; i >= 0; i--) {
            if (score[i] > k) { 
                continue;
            }
            v.add(score[i]);
            cnt++;
            if (cnt % m == 0 && cnt != 0) { // 벡터에 한 상자가 다 모였을 때
                int min = Collections.min(v); // 벡터에서 최솟값 찾기
                answer += min * m; // 합 더하기
                v.clear(); // 벡터 비우기
            }
        }

        return answer;
    }
}