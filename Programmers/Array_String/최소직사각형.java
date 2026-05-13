import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int index = 0;
        int len = sizes.length;
        
        int [] widths = new int[len];
        int [] heights = new int [len];
        
        for (int i = 0; i < len; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if (h > w) {
                widths[index] = h;
                heights[index++] = w;
            }
            else {
                widths[index] = w;
                heights[index++] = h;
            }
        }
        int width = Arrays.stream(widths).max().getAsInt();
        int height = Arrays.stream(heights).max().getAsInt();
        
        return width * height;
    }
}