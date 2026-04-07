import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        ArrayList<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        // 선수 목록 저장
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        
        for(String c : callings){
            
            int index = map.get(c);
            map.put(c, map.getOrDefault(c, 0) -1);
            
            String front = players[index-1];
            
            map.put(front, map.getOrDefault(front, 0) +1);
            
            players[index] = front;
            players[index-1] = c;
        }
        
        return players;
    }
}