import java.util.*;

class Solution {
    
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    public int[] solution(String[] maps) {
        
        int m = maps.length;
        int n = maps[0].length();
        
        // 배열 초기화
        int[][] world = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c = maps[i].charAt(j);
                
                if(c == 'X') world[i][j] = 0;
                else world[i][j] = c - '0';
            }
        }
        
        // 정답 배열
        ArrayList<Integer> result = new ArrayList<>();
        
        // 탐색하면서 섬 확인
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                // 0이 아니라면 (방문한 곳은 0처리)
                if(world[i][j] != 0){
                    int value = bfs(i, j, world[i][j], world, m, n);
                    result.add(value);
                }
            }
        }
        
        if(result.isEmpty()) return new int[]{-1};
        else{
            int[] answer = new int[result.size()];
            Collections.sort(result);
            
            for(int i = 0; i < result.size(); i++){
                answer[i] = result.get(i);
            }
            return answer;
        }
    }
    
    public int bfs(int y, int x, int value, int[][] world, int m, int n){
        
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{y, x, value});
        world[y][x] = 0;
        
        int totalValue = 0;
        
        while(!que.isEmpty()){
            int[] poll = que.poll();
            int curY = poll[0];
            int curX = poll[1];
            int curValue = poll[2];
            
            totalValue += curValue;
            
            for(int i = 0; i < 4; i++){
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];
                
                if(nextY >= 0 && nextY < m && nextX >= 0 && nextX < n && world[nextY][nextX] != 0){
                    que.offer(new int[]{nextY, nextX, world[nextY][nextX]});
                    world[nextY][nextX] = 0;
                }
            }
        }
        
        return totalValue;
    }
}



