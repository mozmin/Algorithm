import java.util.*;

class Solution {
    
    int[] moveY = {0, 0, 1, -1};
    int[] moveX = {1, -1, 0, 0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int n = 0; n < 5; n++){
            
            boolean check = false;
            outer: for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(places[n][i].charAt(j) == 'P' && !bfs(places, n, i, j)){
                        System.out.println("Test");
                        answer[n] = 0;
                        check = true;
                        break outer;
                    }
                }
            }
            if(!check) answer[n] = 1;
        }
        return answer;
    }
    
    public boolean bfs(String[][] places, int n, int y, int x){
        
        Deque<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        que.offer(new int[]{y, x, 0});
        visited[y][x] = true;
        
        while(!que.isEmpty()){
            
            int[] poll = que.poll();
            int curY = poll[0];
            int curX = poll[1];
            int curCount = poll[2];
            
            // 최대 이동거리 2이내에 P가 있다면 false 반환
            if((curCount == 1 || curCount == 2) && places[n][curY].charAt(curX) == 'P'){
                System.out.println(curY + " | " + curX + " / P: " + y + " | " + x + " | " + places[n][curY].charAt(curX) + " | " + curCount);
                return false;
            }
            if(curCount >= 2) continue;
            
            for(int i =0; i < 4; i++){
                int nextY = curY + moveY[i];
                int nextX = curX + moveX[i];
                
                if(nextY >= 0 && nextY < 5 && nextX >= 0 && nextX < 5
                  && places[n][nextY].charAt(nextX) != 'X' && !visited[nextY][nextX]){
                    que.offer(new int[]{nextY, nextX, curCount+1});
                    visited[nextY][nextX] = true;
                }
            }
        }
        return true;
    }
    
    
}



