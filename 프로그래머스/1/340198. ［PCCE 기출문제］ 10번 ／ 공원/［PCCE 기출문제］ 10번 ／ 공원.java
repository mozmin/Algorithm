import java.util.*;

class Solution {
    
    int answer;
    
    public int solution(int[] mats, String[][] park) {
        
        answer = -1;
        
        int[] newMat = Arrays.stream(mats).boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(i -> i).toArray();
        
        for(int m : newMat){
        
            for(int i = 0; i<park.length; i++){
            for(int j = 0; j < park[0].length; j++){
                
                if(park[i][j].equals("-1") && findMat(i, j, m, park)) return answer;
            }
        }
            
        }
        
        return answer;
    }
    
    public boolean findMat(int i, int j, int m, String[][] park){
        
            
        int count = 0;
        outer: for(int x = i; x < i+m; x++){
            for(int y = j; y < j+m; y++){
                    
                if(x < park.length && y < park[0].length && park[x][y].equals("-1")) count++;
                else break outer;
            }
        }
            
        if(count == m*m){
            answer = m;
            return true;
        }
        
        return false;
    }
    
}