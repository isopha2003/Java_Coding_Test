import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(String[][] book_time) {
        int room = 0;
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < book_time.length; i++) {
            String[] sTime = book_time[i][0].split(":");
            int sHour = Integer.parseInt(sTime[0]); 
            int sMin = Integer.parseInt(sTime[1]);
            int startTime = sHour * 100 + sMin;
            
            String[] eTime = book_time[i][1].split(":");
            int eHour = Integer.parseInt(eTime[0]);
            int eMin = Integer.parseInt(eTime[1]);
            int endTime = eHour * 100 + eMin;
            
            int idx = 0;
            boolean possible = false;
            for (int j = 0; j < list.size(); j++) {
                int start = list.get(j)[0];
                int end = list.get(j)[1];
                if (startTime > start) { // 기존 투숙객의 시작 시간보다 현재 들어온 투숙객의 시작 시간이 더 느린 경우
                    int eh = end / 100;
                    int em = end % 100;
                    if (em + 10 >= 60) {
                        eh += 1;
                        em = (em + 10) - 60;
                    } else {
                        em += 10;
                    }
                    int pt = eh * 100 + em;
                    if (startTime >= pt) {
                        possible = true;
                        idx = j;
                        break;
                    } 
                }
                else if (startTime < start) { // 기존 투숙객의 시작 시간보다 현재 들어온 투숙객의 시작 시간이 더 빠른 경우
                    int sh = start / 100;
                    int sm = start % 100;
                    if (sm - 10 < 0) {
                        sh -= 1;
                        sm = sm + 60 - 10;
                    } else {
                        sm -= 10;
                    }
                    int mt = sh * 100 + sm;
                    if (endTime <= mt) {
                        possible = true;
                        idx = j;
                        break;
                    }
                }
            }
            if (!possible) {
                list.add(new int[]{startTime, endTime});
                room++;
            } else {
                list.set(idx, new int[]{startTime, endTime});
            }
        }
        return room;
    }
}