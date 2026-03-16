import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 1. 오늘 날짜를 총 일수로 변환
        int todayDays = getDays(today);
        
        // 2. 약관 정보를 Map에 저장
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            termMap.put(s[0], Integer.parseInt(s[1]) * 28); // 월을 일수로 미리 계산
        }
        
        List<Integer> expiredList = new ArrayList<>();
        
        // 3. 개인정보 만료 여부 확인
        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            int collectedDays = getDays(s[0]);
            int termDays = termMap.get(s[1]);
            
            // 만료일 = 수집일 + 유효기간
            // 만약 만료일이 오늘보다 작거나 같다면? (오늘 날짜가 만료일 이후라면 파기)
            if (collectedDays + termDays <= todayDays) {
                expiredList.add(i + 1);
            }
        }
        
        // 4. 리스트를 배열로 변환
        return expiredList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // 날짜 문자열을 총 일수로 바꾸는 헬퍼 함수
    private int getDays(String date) {
        String[] parts = date.split("\\.");
        int y = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int d = Integer.parseInt(parts[2]);
        return (y * 12 * 28) + (m * 28) + d;
    }
}