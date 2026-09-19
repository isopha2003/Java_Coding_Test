class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder(); 
        String[] words = s.split(" ", -1); 
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 0) {
                // 첫 글자 대문자, 나머지 소문자 처리
                String firstChar = Character.toString(Character.toUpperCase(word.charAt(0)));
                String rest = word.substring(1).toLowerCase();   
                answer.append(firstChar).append(rest);
            }        
            // 마지막 단어가 아닐 때만 공백 추가
            if (i < words.length - 1) {
                answer.append(" ");
            }
        }       
        return answer.toString(); // StringBuilder를 String으로 변환
    }
}