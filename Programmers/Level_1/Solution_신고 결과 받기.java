import java.util.Map;
import java.util.HashMap;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = 0;
        }
        Map<String, Integer> nameId = new HashMap<>();
        // 해시맵에 이름과 인덱스 번호 저장
        for (int i = 0; i < id_list.length; i++) {
            nameId.put(id_list[i], i);
        }
        // 신고 여부 확인 배열 초기화
        boolean [][]reportCheck = new boolean[id_list.length][id_list.length];
        for (int i = 0; i < reportCheck.length; i++) {
            for (int j = 0; j < reportCheck[i].length; j++) {
                reportCheck[i][j] = false;
            }
        }
        int []reportCount = new int[id_list.length];
        for (int i = 0; i < reportCount.length; i++) {
            reportCount[i] = 0;
        }
        for (int i = 0; i < report.length; i++) {
            String []split = report[i].split(" ");
            int reporter = nameId.get(split[0]);
            int subject = nameId.get(split[1]);
            if (reportCheck[reporter][subject] == false) { // 아직 신고를 안했을 때
                reportCheck[reporter][subject] = true; // 신고 체크 후
                reportCount[subject]++; // 신고 횟수 증가
            }
        }
        for (int i = 0; i < reportCheck.length; i++) {
            for (int j = 0; j < reportCheck[i].length; j++) {
                if (reportCheck[i][j] == true && reportCount[j] >= k) {
                    answer[i]++;
                }
            } 
        }
        return answer;
    }
}