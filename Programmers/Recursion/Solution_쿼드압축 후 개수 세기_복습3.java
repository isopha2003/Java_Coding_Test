class Solution {
    private int[][] arr;
    private int[] result = new int[2];
    public int[] solution(int[][] arr) {
        this.arr = arr;
        compress(arr.length, arr[0][0], 0, 0);
        
        return result;
    }
    private void compress(int size, int start, int row, int col) {
        if (size <= 1) {
            result[start]++;
            return;
        }
        int r = row;
        for (int i = 0; i < size; i++, r++) {
            int c = col;
            for (int j = 0; j < size; j++, c++) {
                if (arr[r][c] != start) {
                    compress(size / 2, arr[row][col], row, col);
                    compress(size / 2, arr[row][size / 2 + col], row, size / 2 + col);
                    compress(size / 2, arr[size / 2 + row][col], size / 2 + row, col);
                    compress(size / 2, arr[size / 2 + row][size / 2 + col], size / 2 + row, size / 2 + col);
                    return;
                }
            }
        }
        result[start]++;
        return;
    }
}