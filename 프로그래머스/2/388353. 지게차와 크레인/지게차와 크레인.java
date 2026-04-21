import java.util.*;
class Solution {
    
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        String[][] containers = new String[storage.length + 2][storage[0].length() + 2];
        for(int i = 0; i < containers.length; i++){
            Arrays.fill(containers[i], "");
        }
        
        // 배열 초기화
        for(int i = 1; i <= storage.length; i++){
            for(int j = 1; j <= storage[0].length(); j++){
                containers[i][j] = String.valueOf(storage[i-1].charAt(j-1));
            }
        }
        
        // 탐색
        for(int r = 0; r < requests.length; r++){
            String value = requests[r];
            
            // 지게차로 접근 가능한 컨테이너만
            if(value.length() == 1){
                List<int[]> removeList = new ArrayList<>();

                for(int i = 1; i <= storage.length; i++){
                    for(int j = 1; j <= storage[0].length(); j++){
                        if(value.equals(containers[i][j]) && check4Walls(containers, i, j)) {
                            removeList.add(new int[]{i, j});
                        }
                    }
                }

                // 한 번에 제거
                for(int[] pos : removeList){
                    containers[pos[0]][pos[1]] = "";
                }
            }
            
            // 모든 컨테이너
            else if (value.length() == 2){
                value = String.valueOf(value.charAt(0));
                for(int i = 1; i <= storage.length; i++){
                    for(int j = 1; j <= storage[0].length(); j++){
                        if(value.equals(containers[i][j])) containers[i][j] = "";
                    }
                }
            }
                  
        }
        
        // 비어있지 않은 컨테이너 카운트
        for(int i = 1; i < containers.length; i++){
            for(int j = 1; j < containers[0].length; j++){
                if(!"".equals(containers[i][j])) answer++;
            }
        }
        
        return answer;
    }
    
    // (0, 0) 부터 시작해서 해당 컨테이너에 접근이 가능한지 파악
    // true -> 해당 컨테이너 주변에 빈 공간이 있다.
    // false -> 해당 컨테이너 주변이 전부 막혀있다.
    public boolean check4Walls(String[][] containers, int y, int x){
        
        int m = containers.length;
        int n = containers[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{0, 0});
        
        visited[0][0] = true;
        
        while(!que.isEmpty()){
            
            int[] poll = que.poll();
            int curY = poll[0];
            int curX = poll[1];
            
            if(curY == y && curX == x) return true;
            
            for(int i = 0; i < 4; i++){
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];
                
                if(nextY >= 0 && nextY < m && nextX >= 0 && nextX < n 
                   && !visited[nextY][nextX] 
                   && (containers[nextY][nextX].equals("") || (nextY == y && nextX == x))) {

                    que.offer(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                }
                
            }
        }
        
        
        return false;
    }
}