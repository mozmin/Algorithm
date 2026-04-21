import java.util.*;

class Solution {
    
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    public int solution(String[] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        int[] startPoint = new int[2];
        int[] leverPoint = new int[2];
        int[] exitPoint = new int[2];
        
        // 배열 초기화
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                switch(maps[i].charAt(j)){
                    case 'S':
                        startPoint[0] = i;
                        startPoint[1] = j;
                        break;
                    case 'L':
                        leverPoint[0] = i;
                        leverPoint[1] = j;
                        break;
                    case 'E':
                        exitPoint[0] = i;
                        exitPoint[1] = j;
                        break;
                    case 'X':
                        visited[i][j] = true;
                        break;       
                }
            }
        }
        
        // start -> Lever
        int leverCost = bfs(visited.clone(), startPoint[0], startPoint[1], leverPoint[0], leverPoint[1]);

        // Lever -> Exit
        int exitCost = bfs(visited.clone(), leverPoint[0], leverPoint[1], exitPoint[0], exitPoint[1]);
        
        if(leverCost == -1 || exitCost == -1) return -1;
        else return leverCost + exitCost;
    }
    
    public int bfs(boolean[][] visited, int y, int x, int endY, int endX){
        
        // visited 배열 깊은 복사
        boolean[][] copy = new boolean[visited.length][];
        for (int i = 0; i < visited.length; i++) {
            copy[i] = visited[i].clone();
        }
        
        // 가로, 세로 길이
        int m = copy.length;
        int n = copy[0].length;
        
        // 큐 초기화
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{y, x, 0});
        copy[y][x] = true;
        
        while(!que.isEmpty()){
            int[] poll = que.poll();
            int curY = poll[0];
            int curX = poll[1];
            int curTime = poll[2];
            
            if(curY == endY && curX == endX) return curTime;
            
            for(int i = 0; i < 4; i++){
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];
                
                if(nextY >= 0 && nextY < m && nextX >= 0 && nextX < n && !copy[nextY][nextX]){
                    que.offer(new int[]{nextY, nextX, curTime+1});
                    copy[nextY][nextX] = true;
                }
            }
        }
        return -1;
    }
}


