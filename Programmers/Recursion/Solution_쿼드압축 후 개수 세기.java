import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(int[][] arr) {
        int[] result = {0, 0};
        Map<Integer, Integer> blocks = new HashMap<>();
        Map<Integer, Boolean> possible = new HashMap<>();
        Map<Integer, int[]> compaction = new HashMap<>(); // key: 블록의 사분면, value: [영역의 크기, 0의 개수, 1의 개수]
        
        int len = arr.length;
        int dividend = len;
        boolean bool[][] = new boolean[len][len];
        while(true) {
            if (dividend == 1) {
                break;
            }
            
            int block = 0; // 현재 속한 블록의 위치
            for (int row = 0; row < len; row++) {
                if (row % dividend == 0) {
                    block = block + 1;
                    if (block > (len / dividend)) {
                        block = 1;
                    }
                }
                for (int col = 0; col < len; col++) {
                    if (col % dividend == 0) {
                        if (row % dividend == 0 && col == 0) {
                            blocks.clear();
                            blocks.put(block, arr[row][col]);
                            possible.put(block, true);
                        }
                        else if (row % dividend != 0) {
                            block = block + 1;
                            if (block > (len / dividend)) {
                                block = 1;
                            }
                        }
                        else {
                            block = block + 1;
                            if (block > (len / dividend)) {
                                block = 1;
                            }
                            blocks.put(block, arr[row][col]);
                            possible.put(block, true);
                        }
                    }
                    if (arr[row][col] != blocks.get(block)) {
                        possible.put(block, false);
                    }
                    if (row % dividend == dividend - 1 && col % dividend == dividend - 1) { // 한 블록이 끝났을 때
                        if (possible.get(block) == true) { // 압축 가능할 때
                            int topRow = row - dividend + 1;
                            int topCol = col - dividend + 1;
                            if (!bool[topRow][topCol]) { // 아직 압축이 되지 않은 영역일 때
                                int num = blocks.get(block);
                                if (num == 0) {
                                    result[0]++;
                                }
                                else {
                                    result[1]++;
                                }
                                for (int i = topRow; i <= row; i++) {
                                    for (int j = topCol; j <= col; j++) {
                                        bool[i][j] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            dividend /= 2;
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (!bool[i][j]) {
                    if (arr[i][j] == 0) {
                        result[0]++;
                    }
                    else {  
                        result[1]++;
                    }
                }
            }
        }
        return result;
    }
}