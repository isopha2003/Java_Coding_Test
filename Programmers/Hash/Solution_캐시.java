import java.util.Map;
import java.util.HashMap;

class Solution {
    // 캐시에 데이터가 존재하는지 탐색
    public boolean searchCache(Map<String, Integer> cache, String city) {
        boolean find = false;
        for (String key : cache.keySet()) {
            if (city.equals(key)) {
                cache.put(key, 0); // 사용 주기 초기화
                find = true;
                break;
            }
        }
        return find;
    }
    // 캐시에 데이터 삽입. search 실패 시 호출
    public void saveCache(Map<String, Integer> cache, int cacheSize, String city) {
        if (cache.size() >= cacheSize) {
            String key = "";
            int max = 0;
            for (Map.Entry<String, Integer> entry : cache.entrySet()) {
                int value = entry.getValue();
                if (value > max) {
                    max = value;
                    key = entry.getKey();
                }
            }
            cache.remove(key);
        }
        cache.put(city, 0);
    }
    // 캐시의 사용 주기 증가
    public void increaseLRU(Map<String, Integer> cache) {
        for (String key : cache.keySet()) {
            cache.put(key, cache.getOrDefault(key, 0) + 1); // 사용 주기 증가
        }
    }
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        int answer = 0;
        Map<String, Integer> cache = new HashMap<>();
        
        for (String i : cities) {
            i = i.toUpperCase();
            if(!searchCache(cache, i)) { // 캐시에서 발견되지 않았을 때
                answer += 5;
                saveCache(cache, cacheSize, i);
            }
            else {
                answer += 1;
            }
            increaseLRU(cache);
        }
        return answer;
    }
}