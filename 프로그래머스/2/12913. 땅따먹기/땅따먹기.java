import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dist = new int[land.length][4];
        for(int i = 0; i < 4; i++){
            dist[0][i] = land[0][i];
        }
        
        for(int i = 1; i < land.length; i++){
            
            for(int j = 0; j < 4; j++){
                dist[i][j] = land[i][j] + maxValue(i, j, dist);
            }
        }
        
        for(int i = 0; i < 4; i++){
            answer = Math.max(answer, dist[land.length-1][i]);
        }
        
        return answer;
    }
    
    public int maxValue(int n, int index, int[][] dist){
        
        int max = 0;
        
        for(int i = 0; i < 4; i++){
            if(i == index) continue;
            
            max = Math.max(max, dist[n-1][i]); 
        }
        
        return max;
    }
    
}