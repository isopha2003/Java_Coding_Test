import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {       
        Map<String, Integer> nameRanking = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            nameRanking.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            int index = nameRanking.get(callings[i]);
            String temp = players[index - 1];
            players[index - 1] = players[index];
            players[index] = temp;
            nameRanking.put(players[index - 1], index - 1);
            nameRanking.put(players[index], index);
        }
        
        return players;
    }
}