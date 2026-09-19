class Solution {
    int[] result;
    public int[] solution(int[][] arr) {
        result = new int[2];
        compress(arr, 0, 0, arr.length);
        
        return result;
    }
    public void compress(int[][] arr, int r, int c, int size) {
        int first = arr[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (first != arr[i][j]) {
                    int half = size / 2;
                    compress(arr, r, c, half);
                    compress(arr, r, c + half, half);
                    compress(arr, r + half, c, half);
                    compress(arr, r + half, c + half, half);
                    return; 
                    // first와 다르다면 더 이상 비교할 필요가 없기 때문에 return
                }
            }
        }
        result[first]++;
    }
}