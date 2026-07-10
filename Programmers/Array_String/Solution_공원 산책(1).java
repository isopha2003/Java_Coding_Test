import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int height = park.length; // 공원 전체 높이
        int width = park[0].length; // 공원 전체 너비
        
        boolean available = true;
        
        // mats 내림차순으로 정렬
        Arrays.sort(mats);
        int len = mats.length;
        int[] mat = new int[len];
        for (int i = 0; i < len; i++) {
            mat[len - i - 1] = mats[i];
        }
        
        for (int m : mat) {
            for (int i = 0; i <= height - m; i++) {
                for (int j = 0; j <= width - m; j++) {
                    available = true;
                    for (int p = i; p < i + m; p++) {
                        if (!available) {
                            break;
                        }
                        for (int q = j; q < j + m; q++) {
                            if (!park[p][q].equals("-1")) {
                                available = false;
                                break;
                            }
                        }
                    }
                    if (available) {
                        return m;
                    }
                }   
            }   
        }
        return -1;
    }
}