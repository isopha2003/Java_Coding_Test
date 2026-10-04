import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[][] wires) {
        int result = 100;
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < wires.length; i++) {
            setA.add(wires[i][0]);
            setB.add(wires[i][1]);
            while(true) {
                if (setA.size() + setB.size() == wires.length + 1) break;
                for (int j = 0; j < wires.length; j++) {
                    if (i == j) continue;
                    int w1 = wires[j][0];
                    int w2 = wires[j][1];
                    if (setA.contains(w1) || setA.contains(w2)) {
                        setA.add(w1);
                        setA.add(w2);
                    } else if (setB.contains(w1) || setB.contains(w2)) {
                        setB.add(w1);
                        setB.add(w2);
                    }
                }
            }
            result = Math.min(result, Math.abs(setA.size() - setB.size()));
            setA.clear();
            setB.clear();
        }
        return result;
    }
}