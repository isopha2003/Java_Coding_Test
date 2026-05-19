import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {
    private Set<Integer> powerGrid1 = new HashSet<>();
    private Set<Integer> powerGrid2 = new HashSet<>();
    private List<int[]> temp = new ArrayList<>();
    
    public boolean connect(int wire1, int wire2) {
        boolean isContain = false;
        if (powerGrid1.contains(wire1) || 
            powerGrid1.contains(wire2)) { // 1번 전력망과 연결되어 있을 때
            powerGrid1.add(wire1);
            powerGrid1.add(wire2);
            isContain = true;
        }
        if (powerGrid2.contains(wire1) ||
            powerGrid2.contains(wire2)) { // 2번 전력망과 연결되어 있을 때
            powerGrid2.add(wire1);
            powerGrid2.add(wire2);
            isContain = true;
        }
        return isContain;
    }
    public int solution(int n, int[][] wires) {
        int len = wires.length;
        int answer = len;
        
        for (int i = 0; i < len; i++) {
            powerGrid1.add(wires[i][0]);
            powerGrid2.add(wires[i][1]);

            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                int wire1 = wires[j][0];
                int wire2 = wires[j][1];
                
                if (!connect(wire1, wire2)) { // 두 전력망 모두 연결되어 있지 않을 때
                    temp.add(new int[] {wire1, wire2});
                }
            }
            while(true) {
                if (temp.size() == 0) {
                    break;
                }
                for (int j = 0; j < temp.size(); j++) {
                    int wire1 = temp.get(j)[0];
                    int wire2 = temp.get(j)[1];
                    if (connect(wire1, wire2)) {
                        temp.remove(j);
                    }
                }
            }
            answer = Math.min(answer, Math.abs(powerGrid1.size() - powerGrid2.size()));
            powerGrid1.clear();
            powerGrid2.clear();
            temp.clear();
        }
        return answer;
    }
}