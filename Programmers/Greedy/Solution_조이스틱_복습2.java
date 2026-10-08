import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String name) {
        int len = name.length();
        int cntAlpha = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0); // 최초 시작 위치 저장
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            if (c != 'A') {
                if (c < 'N') {
                    cntAlpha += c - 'A';
                } else {
                    cntAlpha += 'Z' - c + 1;
                }
                if (!list.contains(i)) list.add(i);
            }
        }
        int cntMove = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            int a = list.get(i);
            int b = list.get(i + 1);
            int move = (a * 2) + (len - b);
            cntMove = Math.min(cntMove, move);
        }
        cntMove = Math.min(cntMove, list.get(list.size() - 1));
        for (int i = list.size() - 1; i > 0; i--) {
            int a = list.get(i);
            int b = list.get(i - 1);
            int move = ((len - a) * 2) + b;
            cntMove = Math.min(cntMove, move);
        }
        
        return cntAlpha + cntMove;
    }
}