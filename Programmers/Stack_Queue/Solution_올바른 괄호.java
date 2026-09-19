import java.util.Vector;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        StringBuilder sb = new StringBuilder(s);
        Vector<Character> v = new Vector<Character>();
        for (int i = 0;  i < sb.length(); i++) {
            char c = sb.charAt(i);  
            if (c == '(') { 
                v.add(c);
            }
            else if (c == ')') {
                if (v.size() == 0) {
                    answer = false;
                    return answer;
                }
                else {
                    v.remove(v.size() - 1);
                }
            }
        }
        if (v.size() != 0) {
            answer = false;
            return answer;
        }
        return answer;
    }
}