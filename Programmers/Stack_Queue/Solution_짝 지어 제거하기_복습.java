import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean removed = false;
        
        for (int i = 0; i < s.length(); i++) {
            removed = false;
            char c = s.charAt(i);
            
            while (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                removed = true;
            }
            if(!removed) {
                stack.push(c);
            }
        }
        return (stack.isEmpty() ? 1 : 0);
    }
}