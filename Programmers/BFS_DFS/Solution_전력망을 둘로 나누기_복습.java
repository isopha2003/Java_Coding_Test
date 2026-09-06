import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 100;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<int[]> temp = new HashSet<>();
        
        for (int i = 0; i < n - 1; i++) { // 나눠지는 전력망
            set1.clear();
            set2.clear();
            temp.clear();
            
            set1.add(wires[i][0]);
            set2.add(wires[i][1]);
            for (int j = 0; j < n - 1; j++) {
                if (i == j) { // 현재 전력망이 나눠진 전력망일 때
                    continue;
                }
                else {
                    temp.add(new int[]{wires[j][0], wires[j][1]});
                }
            }
            Set<int[]> temp2 = new HashSet<>();
            while (temp.size() > 0) {
                for (int[] items : temp) {
                    if (set1.contains(items[0]) || set1.contains(items[1])) {
                        set1.add(items[0]);
                        set1.add(items[1]);
                        temp2.add(items);
                    }
                    else if (set2.contains(items[0]) || set2.contains(items[1])) {
                        set2.add(items[0]);
                        set2.add(items[1]);
                        temp2.add(items);
                    }
                }
                temp.removeAll(temp2);
            }
            temp2.clear();
            int size1 = set1.size();
            int size2 = set2.size();
            answer = 
                Math.min(answer, ((size1 > size2) ? size1 - size2 : size2 - size1));
        }
        return answer;
    }
}