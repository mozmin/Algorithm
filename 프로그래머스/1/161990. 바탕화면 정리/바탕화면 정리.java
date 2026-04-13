import java.util.*;
class Solution {
    
    int minX;
    int minY;
    int maxX;
    int maxY;
    public int[] solution(String[] wallpaper) {
        minX = Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        maxY = Integer.MIN_VALUE;
        
        int m = wallpaper.length;
        int n = wallpaper[0].length();
        
        int[][] window = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(wallpaper[i].charAt(j) == '#') window[i][j] = 1;
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(window[i][j] == 1) check(window, i, j);
            }
        }
        
        return new int[]{minY, minX, maxY + 1, maxX + 1};
    }
    
    public void check(int[][] window, int i, int j){
        
        minX = Math.min(minX, j);
        minY = Math.min(minY, i);
        
        maxX = Math.max(maxX, j);
        maxY = Math.max(maxY, i);
    }
}