import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char arr[] = s.toCharArray();
        int len = arr.length;
        boolean isSuccess = true;
        for (int i = 0; i < len; i++) {
            Stack<Character> stack = new Stack<>();
            isSuccess = true;
            for (int j = 0; j < len; j++) {
                char c1 = arr[(i + j) % len];
                if (c1 == '(' || c1 == '{' || c1 == '[') {
                    stack.push(c1);
                }
                else {
                    if (stack.size() == 0) {
                        isSuccess = false;
                        break;
                    }
                    char c2 = stack.pop();
                    if (!((c2 == '(' && c1 == ')') || 
                          (c2 == '{' && c1 == '}') ||
                          (c2 == '[' && c1 == ']'))) {
                        isSuccess = false;
                        break;
                    }
                }
            }
            if (stack.size() != 0) {
                isSuccess = false;
            }
            if (isSuccess) {
                answer++;
            }
        }
        
        return answer;
    }
}