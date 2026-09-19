import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;        
        List<Integer> primes = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        boolean isPrime = true;
        for (int i = 2; i <= 100; i++) {
            isPrime = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) { isPrime = false; break; }
            }    
            if (isPrime) { primes.add(i); }
        }
        for (int i = 0; i < arr.length; i++) {
            Map<Integer, Integer> tempMap = new HashMap<>();
            while(true) {
                if (arr[i] == 1) { break; }
                for (Integer p : primes) {
                    if (arr[i] < p) { break; }
                    if (arr[i] == p) {
                        tempMap.put(p, tempMap.getOrDefault(p, 0) + 1);
                        arr[i] = 1;
                        break;
                    }
                    if (arr[i] % p == 0) {
                        tempMap.put(p, tempMap.getOrDefault(p, 0) + 1);
                        arr[i] /= p;
                        break;
                    }
                }
            }
            for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
                int key = entry.getKey();
                if (map.getOrDefault(key, 0) < entry.getValue()) {
                    map.put(key, entry.getValue());
                }
            }
        }
        for (Integer p : primes) {
            if (map.get(p) == null) { continue; }
            answer *= Math.pow(p, map.get(p));
        }
        return answer;
    }
}