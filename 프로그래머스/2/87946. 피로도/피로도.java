import java.util.*;

class Solution {
    
    static int max;
    public int solution(int k, int[][] dungeons) {
        
        max = 0;
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, visited);
        
        return max;
    }
    
    public void dfs(int k, int[][] dungeons, int count, boolean[] visited){
        

        max = Math.max(max, count);

        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0] && k >= dungeons[i][1]){
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, count+1, visited);
                visited[i] = false;
            }
        }
    }
    
}