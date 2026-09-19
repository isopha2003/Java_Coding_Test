import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> in = new TreeMap<String, Integer>(); // 차량번호, 입차 시간 저장
        Map<String, Integer> total = new TreeMap<String, Integer>(); // 차량번호, 머물렀던 시간 저장
        
        int defaultTime = fees[0]; // 기본 시간
        int defaultFee = fees[1]; // 기본 요금
        int unitTime = fees[2]; // 단위 시간
        int unitFee = fees[3]; // 단위 요금
        
        for (int i = 0; i < records.length; i++) {
            String[] info = records[i].split(" "); // 시간, 번호, 입/출 여부
            String[] time = info[0].split(":"); // 시간, 분
            int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            
            switch(info[2]) {
                case "IN": {
                    in.put(info[1], minute); // 차량번호, 입차 시간 저장
                    break;
                }
                case "OUT": {
                    minute = minute - in.get(info[1]); // 출차 시간 - 입차 시간
                    total.put(info[1], total.getOrDefault(info[1], 0) + minute); // 총 주차 시간 저장
                    in.remove(info[1]);
                    break;
                }
            }
        }
        if (!in.isEmpty()) { // 출차 기록이 없는 차
            for (Map.Entry<String, Integer> entry : in.entrySet()) {
                String num = entry.getKey();
                int totalTime = 1439 - entry.getValue();
                total.put(num, total.getOrDefault(num, 0) + totalTime);
            }
        }
        int[] result = new int[total.size()];
        int idx = 0;
        
        for (Map.Entry<String, Integer> entry : total.entrySet()) {
            int totalTime = entry.getValue();
            if (totalTime <= defaultTime) { // 기본 시간보다 적게 주차했을 때
                result[idx++] = defaultFee; // 기본 요금 정산
            } else { // 기본 시간보다 길게 주차했을 때
                if ((totalTime - defaultTime) / unitTime == 0) { // 
                    result[idx++] = defaultFee + unitFee;
                } else { 
                    if ((totalTime - defaultTime) % unitTime == 0) {
                        result[idx++] = defaultFee + (((totalTime - defaultTime) / unitTime) * unitFee);
                    } else {
                        result[idx++] = defaultFee + (((totalTime - defaultTime) / unitTime) * unitFee) + unitFee;   
                    }
                }
            }
        }
        return result;
    }
}