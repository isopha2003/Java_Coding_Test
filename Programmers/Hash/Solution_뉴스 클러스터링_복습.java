import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> unionMap = new HashMap<>();
        
        float union = 0;
        float intersection = 0;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if (Character.isLetter(c1) && Character.isLetter(c2)) { // 문자일 때
                sb.append(c1);
                sb.append(c2);
                String s = sb.toString().toUpperCase();
                map1.put(s, map1.getOrDefault(s, 0) + 1);
                unionMap.put(s, unionMap.getOrDefault(s, 0) + 1);
                sb.setLength(0);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if (Character.isLetter(c1) && Character.isLetter(c2)) { // 문자일 때
                sb.append(c1);
                sb.append(c2);
                String s = sb.toString().toUpperCase();
                map2.put(s, map2.getOrDefault(s, 0) + 1);
                sb.setLength(0);
            }
            else {
                sb.setLength(0);
            }
        }
        
        for (String key : map2.keySet()) {
            if (unionMap.get(key) != null) { // 해당 값이 이미 존재할 때
                int n = Math.max(unionMap.get(key), map2.get(key));
                unionMap.put(key, n);
            }
            else {
                unionMap.put(key, map2.get(key));
            }
        }
        
        for (String key : unionMap.keySet()) {
            union += unionMap.get(key);
        }
        
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersection = intersection + Math.min(map1.get(key), map2.get(key));
            }
        }

        if (union == 0) {
            return 65536;
        }
        return (int)(intersection / union * 65536);
    }
}