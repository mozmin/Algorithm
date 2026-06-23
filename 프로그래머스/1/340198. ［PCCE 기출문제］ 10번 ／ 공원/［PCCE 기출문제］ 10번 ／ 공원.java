import java.util.*;

class Solution {
    
    int answer;
    
    public int solution(int[] mats, String[][] park) {
        
        answer = -1;
        Arrays.sort(mats);
        int[] newMat = new int[mats.length];
        
        for(int i = 0; i < mats.length; i++){
            newMat[i] = mats[mats.length-i-1];
        }
        
        for(int m : newMat){
            for(int i = 0; i < park.length; i++){
            
                for(int j = 0; j < park[0].length; j++){
                
                    // 만약 -1이라면
                    if(park[i][j].equals("-1")){
                        check(i, j, park, m);
                    }
                    
                    if(answer != -1) return answer;
                }
            }
        }
        return answer;
        
    }
    
    public void check(int i, int j, String[][] park, int m){
        
        for(int a = i; a < i+m; a++){
            for(int b = j; b < j+m; b++){
                
                if(a >= park.length || b >= park[0].length || !park[a][b].equals("-1")) return;
                
            }
        }
        
        answer = m;
        
    }
    
}