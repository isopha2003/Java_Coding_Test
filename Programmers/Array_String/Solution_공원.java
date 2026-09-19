import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // 1. 돗자리 크기를 큰 순서대로 정렬
        Arrays.sort(mats);
        
        // 내림차순으로 확인하기 위해 뒤에서부터 순회
        for (int m = mats.length - 1; m >= 0; m--) {
            int size = mats[m];
            
            // 2. 공원의 모든 좌표를 시작점으로 시도
            if (canPlace(size, park)) {
                return size;
            }
        }
        
        return -1; // 깔 수 있는 돗자리가 없는 경우
    }
    
    // 특정 사이즈의 돗자리를 깔 수 있는지 체크하는 함수
    private boolean canPlace(int size, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;
        
        for (int i = 0; i <= rows - size; i++) {
            for (int j = 0; j <= cols - size; j++) {
                
                // (i, j) 지점에서 size x size 크기가 모두 "-1"인지 확인
                if (checkSquare(i, j, size, park)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean checkSquare(int r, int c, int size, String[][] park) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false; // 사람이 있거나 장애물이 있음
                }
            }
        }
        return true;
    }
}