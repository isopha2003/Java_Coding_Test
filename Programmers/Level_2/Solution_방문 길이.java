import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        char c;
        int x = 0;
        int y = 0;
        int beforeX;
        int beforeY;
        boolean isMoved = true;
        Set<String> coordinates = new HashSet<>();
        for (int i = 0; i < dirs.length(); i++) {
            beforeX = x;
            beforeY = y;
            isMoved = true;
            c = dirs.charAt(i);
            switch(c) {
                case 'U': {
                    if (y < 5) y++; 
                    else isMoved = false;
                    break;
                }
                case 'D': {
                    if (y > -5) y--;
                    else isMoved = false;
                    break;
                }
                case 'L': {
                    if (x > -5) x--;
                    else isMoved = false;
                    break;
                }
                case 'R': {
                    if (x < 5) x++;
                    else isMoved = false;
                    break;
                }
            }
            if (isMoved) {
                coordinates.add(beforeX + "," + beforeY + "," + x + "," + y);
                coordinates.add(x + "," + y + "," + beforeX + "," + beforeY);
            }
        }
        
        return coordinates.size() / 2;
    }
}