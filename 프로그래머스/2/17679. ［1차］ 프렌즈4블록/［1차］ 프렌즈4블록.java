import java.util.*;

class Solution {
    
    int answer;
    public int solution(int m, int n, String[] board) {
        answer = 0;
        
        // 배열 초기화
        String[][] arr = new String[m][n];
        for(int i = 0; i < m; i++){
            
            String split = board[i];
            for(int j = 0; j < n; j++){
                arr[i][j] = String.valueOf(split.charAt(j));
            }
        }
        
        ArrayList<int[]> removed = new ArrayList<>();
        
        // 지울 블록이 없을 때까지 반복
        while(true){
            
            removed.clear();
            boolean isBreak = false;
            
            // m-1 x n-1 까지만 반복
            for(int i = 0; i < m-1; i++){
                for(int j = 0; j < n-1; j++){
                    if(check(i, j, arr)){
                        removed.add(new int[]{i, j});
                        removed.add(new int[]{i, j+1});
                        removed.add(new int[]{i+1, j});
                        removed.add(new int[]{i+1, j+1});
                        isBreak = true;
                    }
                }
            }
            
            
            if(!isBreak) break;
            
            // 4개인 그룹 카운트 및 제거
            for(int[] r : removed){
                int y = r[0];
                int x = r[1];
                
                if(!arr[y][x].equals("")){
                    arr[y][x] = "";
                    answer++;
                }
            }
            
            
            // 지울 블록들 일괄 삭제
            drop(arr);
        }
        
        return answer;
    }
    
    private boolean check(int y, int x, String[][] arr){
        
        String base = arr[y][x];
        
        if(base == "") return false;
        
        if(arr[y+1][x].equals(base) && arr[y][x+1].equals(base) && arr[y+1][x+1].equals(base)) return true;
        
        return false;
        
    }
    
    private void drop(String[][] arr){
    
        // 블록 재정렬
        for(int i = arr.length-1; i >= 0; i--){
            for(int j = arr[0].length-1; j >= 0; j--){
                if(arr[i][j] == ""){
                    
                    int index = i-1;
                    
                    while(index >= 0){
                        if(index >= 0 && arr[index][j] != ""){
                            arr[i][j] = arr[index][j];
                            arr[index][j] = "";
                            break;
                        }
                        index--;
                    }
                }
                
            }
        }
        
    }
    
    
}




