import java.util.*;

class Solution {
    
    String dir = "NSWE";
    int[] moveX = new int[]{0, 0, -1, 1};
    int[] moveY = new int[]{-1, 1, 0, 0};
    
    public int[] solution(String[] park, String[] routes) {
        
        int[] curPosition = new int[2];
        
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length(); j++){
                char c = park[i].charAt(j);
                
                if(c == 'S'){
                    curPosition[0] = i; // Y
                    curPosition[1] = j; // X
                }
            }
        }
        
        for(int i = 0; i < routes.length; i++){
        
            String op = routes[i].substring(0, 1);
            int n = Integer.parseInt(routes[i].substring(2));
            
            curPosition = check(op, n, park, curPosition);
            
        }
        
        
        return curPosition;
    }
    
    public int[] check(String op, int n, String[] park, int[] curPosition){
        
        int index = dir.indexOf(op);
        int newY = curPosition[0];
        int newX = curPosition[1];
        
        for(int i = 0; i < n; i++){
            newY += moveY[index];
            newX += moveX[index];
        
            if(newY >= park.length || newY < 0
              || newX >= park[0].length() || newX < 0 || park[newY].charAt(newX) == 'X'){
                return curPosition;
            }
        }
        
        return new int[]{newY, newX};
    }
}