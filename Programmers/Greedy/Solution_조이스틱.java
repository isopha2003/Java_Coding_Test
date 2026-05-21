class Solution {
    private int count = 0;
    private boolean visited[];
    
    // 최소 거리에 있는 인덱스를 리턴하는 함수
    public int nearIndex(String name, int index, int len) {
        int right = index;
        int rightCnt = 0;
        while(true) {
            char c = name.charAt(right);
            if (c != 'A' && !visited[right]) {
                break;
            }
            right = (right + 1 + len) % len;
            rightCnt++;
        }
        int left = index;
        int leftCnt = 0;
        while(true) {
            char c = name.charAt(left);
            if (c != 'A' && !visited[left]) {
                break;
            }
            left = (left - 1 + len) % len;
            leftCnt++;
        }
        count += Math.min(rightCnt, leftCnt);
        
        if (rightCnt < leftCnt) {
            visited[right] = true;
            return right;
        }
        else {
            visited[left] = true;
            return left;
        }
    }
    
    // 알파벳을 최소 조작으로 변경하는 횟수를 더하는 함수
    public void nearAlpha(char c1, char c2) {
        int up = 0;
        int down = 0;
        char upC = c2;
        char downC = c2;
        while(true) {
            if (c1 == upC) break;
            upC = (char)('A' + (upC - 'A' + 1) % 26);
            up++;
        }
        
        while(true) {
            if (c1 == downC) break;
            downC = (char)('A' + (downC - 'A' - 1 + 26) % 26);
            down++;
        }
        
        count += Math.min(up, down);
    }
    
    public int solution(String name) {
        // 시작 문자 만들기
        int len = name.length();
        visited = new boolean[len];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < len; i++) {
            sb.append("A");
        }                
        
        int index = 0;
        while(true) {
            if (sb.toString().equals(name)) break;
            
            index = nearIndex(name, index, len);
            char c1 = name.charAt(index);
            char c2 = sb.charAt(index);
            
            nearAlpha(c1, c2);
            sb.setCharAt(index, c1);
        }
        
        return count;
    }
}