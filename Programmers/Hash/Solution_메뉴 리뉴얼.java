import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> menus = new HashMap<>();
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            for (int c : course) {
                if (sorted.length() >= c) combine(sorted, c, 0, new StringBuilder(), menus);
            }
        }
        int[] maxOrder = new int[course[course.length - 1] + 1];
        for (int i = 0; i < maxOrder.length; i++) {
            maxOrder[i] = 2;
        }
        for (Map.Entry<String, Integer> entry : menus.entrySet()) {
            int idx = entry.getKey().length();
            if (maxOrder[idx] < entry.getValue()) maxOrder[idx] = entry.getValue();
        }
        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : menus.entrySet()) {
            int idx = entry.getKey().length();
            if (maxOrder[idx] == entry.getValue()) answer.add(entry.getKey());
        }
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    private void combine(String s, int size, int start, StringBuilder sb, Map<String, Integer> menus) {
        if (sb.length() == size) {
            String menu = sb.toString();
            menus.put(menu, menus.getOrDefault(menu, 0) + 1);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            combine(s, size, i + 1, sb, menus);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}