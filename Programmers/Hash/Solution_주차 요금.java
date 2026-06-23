import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> tempMap = new HashMap<>(); // 현재 주차장에 남아 있는 차량
        Map<String, Integer> resultMap = new TreeMap<>(); // 차량이 사용한 총 시간
        
        int defaultTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" "); // 시간, 차량번호, 출입 내역 나누기
            String[] parts = record[0].split(":"); // 시간과 분으로 나누기
            int time = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]); // 시간과 분을 분으로 변환
            
            if (record[2].equals("IN")) { // 차량이 들어갈 때
                tempMap.put(record[1], time); // 차량번호와 들어간 시간 저장
            }
            else { // 차량이 나올 때
                int timeIn = tempMap.get(record[1]); // 차량이 들어간 시간
                if (resultMap.get(record[1]) != null) { // 출입 기록이 이미 있는 차량일 때
                    int timeRemain = resultMap.get(record[1]); // 남아 있던 시간 저장
                    resultMap.put(record[1], time - timeIn + timeRemain); // 원래 남아 있던 시간 + 사용한 시간
                }
                else {
                    resultMap.put(record[1], time - timeIn); // 차량이 사용한 시간 저장
                }
                tempMap.remove(record[1]); // 주차장에 주차 되어 있던 차량 빼기
            }
        }
        if (!tempMap.isEmpty()) { // 주차장이 비어 있지 않을 때
            for (String key : tempMap.keySet()) { // 남은 차량 시간 정리
                int time = 1439 - tempMap.get(key);
                if (resultMap.get(key) != null) {
                    resultMap.put(key, time + resultMap.get(key));
                }
                else {
                    resultMap.put(key, time);
                }
            }
        }
        
        int[] answer = new int[resultMap.size()];
        int index = 0;
        for (String key : resultMap.keySet()) {
            int time = resultMap.get(key);
            if (time < defaultTime) { // 사용 시간이 기본 시간보다 적을 때
                answer[index++] = baseFee;
            }
            else {
                if ((time - defaultTime) % unitTime != 0) {
                    answer[index++] = baseFee + (((time - defaultTime) / unitTime) + 1) * unitFee;
                }
                else {
                    answer[index++] = baseFee + ((time - defaultTime) / unitTime) * unitFee;    
                }
            }
        }
        return answer;
    }
}