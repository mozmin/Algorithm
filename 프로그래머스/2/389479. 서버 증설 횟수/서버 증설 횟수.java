import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // 증설한 서버 <반납 시간, 갯수>
        Map<Integer, Integer> server = new HashMap<>();
        
        for(int i = 0; i < players.length; i++){
            
            // i시간의 플레이어 수
            int playersCount = players[i];
            
            // i시간 기준 증설된 서버 수
            int currentServer = 0;
            for(Integer count : server.values()){
                currentServer += count;
            }
            
            // 현재 증설한 서버 수가 감당 가능한지 체크
            // 증설이 필요한 경우 Map<>의 합 n * m < playersCount
            if(currentServer * m < playersCount && playersCount >= m){
                int needsServer = (playersCount - (currentServer * m)) / m; // 몫
//                 int restPlayers = (playersCount - (currentServer * m)) % m; // 나머지
                
//                 // 만약 나머지가 있다면 서버 +1
//                 if(restPlayers > 0 && restPlayers < m) needsServer++;
                
                // Map<>에 추가
                server.put(i+k, needsServer);
                answer += needsServer;
                
                System.out.println(i + "~" + (i+1) + " | " + playersCount + " | " 
                                   + (currentServer+needsServer) + " | " + needsServer + " | currentServer:" + currentServer);
            }
            
            // 반납해야 할 서버 확인
            for(Integer time : server.keySet()){
                if(time == i+1){
                    server.remove(time);
                    System.out.println("삭제된 시간: " + time);                
                    break; // Map<>은 for문 중에 값 변경이 일어나면 에러가 난다.
                }
            }
            
        }
        
        return answer;
    }
}