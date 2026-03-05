import java.util.Vector;

class Server {
    private int remainingRuntime; // 남은 가동 시간
    
    public Server(int remainingRuntime) {
        this.remainingRuntime = remainingRuntime;
    }
    public void discountRemainingRuntime() { // 가동 시간 줄이기
        remainingRuntime -= 1;
    }
    public int getRemainingRuntime() { // 가동 시간 반환
        return remainingRuntime;
    }
}

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int capacity = m;
        Vector<Server> runningServers = new Vector<Server>();
        
        for (int i = 0; i < players.length; i++) { 
            capacity = m;
            discountRemainingRuntime(runningServers);
            capacity *= runningServers.size() + 1;
            if (players[i] >= capacity) {
                answer += serverExpansion(runningServers, players[i], capacity, m, k);
            }
        }    
        return answer;
    }
    // 서버 증설
    public int serverExpansion(Vector<Server> v, int players, int capacity, 
                               int m, int k) {
        int count = 0;
        while (true) {
            if (capacity > players) {
                break;
            }
            v.add(new Server(k));
            capacity += m;
            count++;
        }
        return count;
    }
    // 현재 실행되는 모든 서버의 남은 시간을 줄임
    public void discountRemainingRuntime(Vector<Server> v) {
        for (int i = v.size() - 1; i >= 0; i--) {
            v.get(i).discountRemainingRuntime();
            if (v.get(i).getRemainingRuntime() == 0) { // 서버의 남은 실행 시간이 없을 때
                v.remove(i); // 그 서버 중지(삭제)
            }
        }
    }
}