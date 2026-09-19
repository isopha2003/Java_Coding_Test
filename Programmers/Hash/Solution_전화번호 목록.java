import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (a, b) -> a.length() - b.length());
        for (int i = phone_book.length - 2; i >= 0; i--) {
            String s = phone_book[i];
            int len = s.length();
            for (int j = i + 1; j < phone_book.length; j++) {
                if (i == j) {
                    continue;
                }
                if (len > phone_book[j].length()) {
                    continue;
                }
                else if (s.equals(phone_book[j].substring(0, len))) {
                    return false;
                }
            }
        }
        return true;
    }
}