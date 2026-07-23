import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        int runTime = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < cities.length; i++) {
            for (String key : map.keySet()) { // 캐시 갱신
                map.put(key, map.get(key) + 1);
            }
            
            String city = cities[i].toUpperCase();
            if (map.get(city) == null) { // cache miss 일 때
                runTime += 5;
                if (map.size() >= cacheSize) { // cache가 다 찼을 때
                    String removeCity = "s";
                    int min = 0;
                    for (String key : map.keySet()) {
                        if (map.get(key) > min) {
                            removeCity = key;
                            min = map.get(key);
                        }
                    }
                    map.remove(removeCity); // 가장 오래 전에 사용한 캐시 삭제
                }
                map.put(city, 0); // 새로운 캐시 삽입
            }
            else {
                runTime++;
                map.put(city, 0); // 사용한 캐시 초기화
            }
        }
        return runTime;
    }
}