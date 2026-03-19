import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int time = 24;
        int answer = 0;
        //종료될 서버의 수
        int[] server = new int[time+k];
        //현재 시점에 활성화된 서버의 수
        int activeServer = 0;
        
        for(int i = 0; i < time; i++){
            //현재 시점에 활성화된 서버에 종료될 서버를 반영함
           activeServer -= server[i];
           //m명당 필요한 서버의 개수를 계산
            int needServer = players[i] / m;
            
            //만약 활성화된 서버보다 필요한 서버의 수가 부족하다면 추가될 서버의 개수와 k시간 뒤 종료될 서버를 계산
            if(needServer > activeServer){
                int addServer = needServer - activeServer;
                activeServer += addServer;
                server[i+k] += addServer;
                answer += addServer;
            }
        }
        return answer;
    }
}