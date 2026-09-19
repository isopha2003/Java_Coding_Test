class Solution {
    public void timeParser(String time, int[] times) {
        String parts[] = time.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        times[0] = min;
        times[1] = sec;
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int []video_lengthArr = new int[2];
        int []posArr = new int[2];
        int []op_startArr = new int[2];
        int []op_endArr = new int[2];
        timeParser(video_len, video_lengthArr);
        timeParser(pos, posArr);
        timeParser(op_start, op_startArr);
        timeParser(op_end, op_endArr);
        if ((posArr[0] > op_startArr[0] || (posArr[0] == op_startArr[0] && posArr[1] >= op_startArr[1])) && 
            (posArr[0] < op_endArr[0] || (posArr[0] == op_endArr[0] && posArr[1] <= op_endArr[1]))) {
            posArr[0] = op_endArr[0];
            posArr[1] = op_endArr[1];
        }
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            switch(command) {
                case "prev": {
                    if (posArr[1] < 10) {
                        if (posArr[0] == 0) {
                            posArr[0] = 0;
                            posArr[1] = 0;
                        }
                        else {
                            posArr[0] -= 1;
                            posArr[1] = posArr[1] + 60 - 10;
                        }
                    }
                    else {
                        posArr[1] -= 10;
                    }
                    if ((posArr[0] > op_startArr[0] || (posArr[0] == op_startArr[0] && posArr[1] >= op_startArr[1])) && 
                        (posArr[0] < op_endArr[0] || (posArr[0] == op_endArr[0] && posArr[1] <= op_endArr[1]))) {
                            posArr[0] = op_endArr[0];
                            posArr[1] = op_endArr[1];
                    }
                    break;
                }
                case "next": {
                    if (posArr[1] + 10 >= 60) { // 현재 동영상의 위치에서 10초 넘겼을 때 60초를 넘기는 경우
                        posArr[0] += 1;
                        posArr[1] = posArr[1] + 10 - 60;
                        if (posArr[0] == video_lengthArr[0] && posArr[1] > video_lengthArr[1]) { // 동영상의 길이를 초과하는 경우
                            posArr[0] = video_lengthArr[0];
                            posArr[1] = video_lengthArr[1];
                        }
                    }
                    else {
                        posArr[1] += 10;
                        if (posArr[0] == video_lengthArr[0] && posArr[1] > video_lengthArr[1]) { // 동영상의 길이를 초과하는 경우
                            posArr[0] = video_lengthArr[0];
                            posArr[1] = video_lengthArr[1];
                        }
                    }
                    if ((posArr[0] > op_startArr[0] || (posArr[0] == op_startArr[0] && posArr[1] >= op_startArr[1])) && 
                        (posArr[0] < op_endArr[0] || (posArr[0] == op_endArr[0] && posArr[1] <= op_endArr[1]))) {
                            posArr[0] = op_endArr[0];
                            posArr[1] = op_endArr[1];
                    }
                    break;
                }
            }
        }
        answer = String.format("%02d:%02d", posArr[0], posArr[1]);
        return answer;
    }
}