import java.util.*;
class Solution {
    
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    int min;
    public int solution(String[] board) {
        min = -1;
        
        int m = board.length;
        int n = board[0].length();
        
        String[][] map = new String[m][n];
        
        int startY = 0;
        int startX = 0;
        
        // map 초기화
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c = board[i].charAt(j);
                
                if(c == 'R'){
                    startY = i;
                    startX = j;
                }
                
                map[i][j] = String.valueOf(c);
            }
        }
        
        bfs(map, startY, startX, m, n);
        
        return min;
    }
    
    public void bfs(String[][] map, int startY, int startX, int m, int n){
        
        Deque<int[]> q = new ArrayDeque<>();
        
        boolean[][] visited = new boolean[m][n];
        
        q.offer(new int[]{startY, startX, 0});
        visited[startY][startX] = true;
        
        while(!q.isEmpty()){
            
            int[] poll = q.poll();
            int curY = poll[0];
            int curX = poll[1];
            int curCount = poll[2];
            
            if(map[curY][curX].equals("G")){
                min = curCount;
            }
            
            for(int i = 0; i < 4; i++){
                int nY = curY;
                int nX = curX;
                
                while (true) {
                    int nextY = nY + dy[i];
                    int nextX = nX + dx[i];

                    // 다음 칸이 범위를 벗어나거나 장애물이라면 더 이상 갈 수 없음
                    if (nextY < 0 || nextY >= m || nextX < 0 || nextX >= n || map[nextY][nextX].equals("D")) {
                        break;
                    }

                    // 조건이 만족하면 해당 방향으로 계속
                    nY = nextY;
                    nX = nextX;
                }

                // 멈춰 선 최종 위치(nY, nX)를 방문한 적이 없다면 큐에 삽입
                if (!visited[nY][nX]) {
                    visited[nY][nX] = true;
                    q.offer(new int[]{nY, nX, curCount + 1});
                }
            }
        }
        
        return;
    } 
}








