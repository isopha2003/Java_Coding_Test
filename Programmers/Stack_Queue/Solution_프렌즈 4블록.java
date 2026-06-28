import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        List<int[]> remove = new ArrayList<>(); // 제거 할 블록의 인덱스 저장
        boolean isFin = false; // 제거할 블록의 유/무 표시
        
        char blocks[][] = new char[m][n];
        for (int i = 0; i < m; i++) { // char 배열로 저장
            for (int j = 0; j < n; j++) {
                blocks[i] = board[i].toCharArray();
            }
        }
        
        while(true) {
            if (isFin) {
                break;
            }
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char b1 = blocks[i][j];
                    char b2 = blocks[i][j + 1];
                    char b3 = blocks[i + 1][j];
                    char b4 = blocks[i + 1][j + 1];
                    
                    if (b1 == b2 && b2 == b3 && b3 == b4 && b1 != ' ') { // 2 x 2 블록이 모두 같을 때
                        remove.add(new int[]{i, j});
                        remove.add(new int[]{i, j + 1});
                        remove.add(new int[]{i + 1, j});
                        remove.add(new int[]{i + 1, j + 1});
                        // 해당하는 인덱스 모두 저장
                    }
                }
            }
            if (remove.isEmpty()) { // 더 이상 제거할 블록이 없을 때
                isFin = true;
            }
            for (int i = 0; i < remove.size(); i++) { // 블록에서 전체 제거
                if (blocks[remove.get(i)[0]][remove.get(i)[1]] == ' ') {
                    continue;
                }
                else {
                    blocks[remove.get(i)[0]][remove.get(i)[1]] = ' ';
                    answer++;
                }
            }
            remove.clear(); // remove 원소 전체 제거
            
            // 블록 내리기
            Deque<int[]> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                q.clear();
                for (int j = m - 1; j >= 0; j--) {
                    if (q.size() > 0 && blocks[j][i] != ' ') {
                        int p[] = q.poll();
                        blocks[p[0]][p[1]] = blocks[j][i];
                        blocks[j][i] = ' ';
                    }
                    if (blocks[j][i] == ' ') { // 비어있는 공간 발견 시,
                        q.offer(new int[]{j, i});
                    }
                }
            }
        }
        return answer;
    }
}