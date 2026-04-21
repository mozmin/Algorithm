import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        // 배열 초기화
        String[][] map = new String[m][n];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = String.valueOf(board[i].charAt(j));
            }
        }
        
        // 4개인 그룹 찾기
        // 2x2 이므로 length-1 만큼만 탐색
        ArrayList<int[]> list = new ArrayList<>();
        
        do{
            list.clear();
            
            for(int i = 0; i < map.length-1; i++){
                for(int j = 0; j < map[0].length-1; j++){
                    
                    String value = map[i][j];
                    if(!value.equals("")
                      && map[i][j+1].equals(value)
                      && map[i+1][j].equals(value)
                      && map[i+1][j+1].equals(value)){
                        list.add(new int[]{i, j});
                        list.add(new int[]{i, j+1});
                        list.add(new int[]{i+1, j});
                        list.add(new int[]{i+1, j+1});
                    }
                }
            }
            
            // 4개인 그룹 카운트 및 제거
            for(int[] l : list){
                int y = l[0];
                int x = l[1];
                
                if(!map[y][x].equals("")){
                    map[y][x] = "";
                    answer++;
                }
            }
            
            // 아래 블록 떨구기
            drop(m, n, map);
            
        }while(!list.isEmpty());
        
        return answer;
    }
    
    public void drop(int m, int n, String[][] map){
        
        // 아래부터 탐색
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                
                // 만약 빈 곳이라면 위에 값을 현재 위치로 이동
                if(map[i][j].equals("")){
                    int nextY = i-1;
                    while(nextY >= 0){
                        if(nextY >=0 && !map[nextY][j].equals("")){
                            map[i][j] = map[nextY][j];
                            map[nextY][j] = "";
                            break;
                        }
                        nextY--;
                    }
                }
            }
        }
    }
    
    
}

