import java.util.Deque;
import java.util.ArrayDeque;

class Solution {   
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<int[]> onBridge = new ArrayDeque<>(); // 다리 위에 올라가 있는 트럭
        int totalTime = 1; // 총 걸린 시간
        int currentWeight = 0; // 현재 다리 위에 있는 트럭 무게
        int index = 1;
        int arrived = 0; // 도착한 트럭 수
        int len = truck_weights.length;
        
        if (len == 1) {
            return bridge_length + 1;
        }
        
        boolean fin = false;
        
        onBridge.offer(new int[]{truck_weights[0], 1});
        currentWeight += truck_weights[0];
        
        
        while(true) {
            if (arrived == len) {
                break;
            }
            
            if (!onBridge.isEmpty()) {
                for (int[] arr : onBridge) {
                    arr[1] += 1;
                }
            }
            
            totalTime++;
            int w = truck_weights[index];
            
            if (!onBridge.isEmpty() && onBridge.peek()[1] > bridge_length) { // 다리에서 다 내려왔을 때
                currentWeight -= onBridge.poll()[0]; // 큐에서 삭제
                arrived++;
            }
            
            if (onBridge.size() + 1 > bridge_length || currentWeight + w > weight) {
                // 트럭 한 대가 더 들어았을 때, 다리에 올라갈 수 있는 트럭의 개수를 초과하거나
                // 다리가 견딜 수 있는 무게를 초과하는 경우
                continue;
            }
            else if (!fin) {
                onBridge.offer(new int[]{w, 1}); // 큐에 들어가는 순간 (올라오는 데 1초가 걸리기 때문)
                currentWeight += w;
                index++;
                if (index >= len) {
                    fin = true;
                    index--;
                }
            }
        }
        
        return totalTime;
    }
}