class Solution {
    public int[] solution(String[] park, String[] routes) {
        int []currentLocation = new int[2]; // 현재 위치를 나타내는 배열
        // 시작 지점 구하기
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    currentLocation[0] = i;
                    currentLocation[1] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < routes.length; i++) {
            String []route = routes[i].split(" ");
            String direction = route[0]; // 방향
            int distance = Integer.parseInt(route[1]); // 이동 거리
            move(park, currentLocation, direction, distance);
        }
        return currentLocation;
    }
    public void move(String[] park, int[] currentLocation, String direction, int distance) {
        int row = currentLocation[0];
        int col = currentLocation[1];
        switch(direction) {
            case "N": {
                for (int i = 1; i <= distance; i++) {
                    if (row - 1 < 0 || park[row - 1].charAt(col) == 'X') { // 범위를 벗어나거나 장애물을 만났을 때
                        row = currentLocation[0];
                        col = currentLocation[1];
                        break;
                    }
                    row -= 1;
                }
                break;
            }
            case "S": {
                for (int i = 1; i <= distance; i++) {
                    if (row + 1 > park.length - 1 || park[row + 1].charAt(col) == 'X') { // 범위를 벗어나거나 장애물을 만났을 때
                        row = currentLocation[0];
                        col = currentLocation[1];
                        break;
                    }
                    row += 1;
                }
                break;
            }
            case "W": {
                for (int i = 1; i <= distance; i++) {
                    if (col - 1 < 0 || park[row].charAt(col - 1) == 'X') { // 범위를 벗어나거나 장애물을 만났을 때
                        row = currentLocation[0];
                        col = currentLocation[1];
                        break;
                    }
                    col -= 1;
                }
                break;
            }
            case "E": {
                for (int i = 1; i <= distance; i++) {
                    if (col + 1 > park[row].length() - 1 || park[row].charAt(col + 1) == 'X') { // 범위를 벗어나거나 장애물을 만났을 때
                        row = currentLocation[0];
                        col = currentLocation[1];
                        break;
                    }
                    col += 1;
                }
                break;
            }
        }
        currentLocation[0] = row;
        currentLocation[1] = col;
    }
}