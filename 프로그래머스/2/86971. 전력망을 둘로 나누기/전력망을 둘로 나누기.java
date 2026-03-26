import java.util.*;

class Solution {
    
    int diff;
    int min;
    public int solution(int n, int[][] wires) {
        diff = 0;
        min = Integer.MAX_VALUE;
        
        // 연결된 와이어 저장
        boolean[][] list = new boolean[n][n];
        for(int i = 0; i < wires.length; i++){
            int from = wires[i][0] - 1;
            int to = wires[i][1] - 1;
            
            list[from][to] = true;
            list[to][from] = true;
        }
        
        // 각 wire 반복마다 하나씩 끊어가며 dfs() 참조
        for(int i = 0; i < wires.length; i++){
            int from = wires[i][0] - 1;
            int to = wires[i][1] - 1;
            
            list[from][to] = false;
            list[to][from] = false;
            
            boolean[] visited = new boolean[n];
            int count = dfs(list, from, visited);
                
            diff = Math.abs(count - (n - count));
            min = Math.min(min, diff);
            
            list[from][to] = true;
            list[to][from] = true;
        }
        
        return min;
    }
    
    public int dfs(boolean[][] list, int index, boolean[] visited){
        
        int count = 1;
        visited[index] = true;
        for(int i = 0; i < list.length; i++){
            
            if(list[index][i] && !visited[i]){
                count += dfs(list, i, visited);
            }
        }
        
        return count;
    }
    
    

}



