import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        
        // 1초부터 시작
        for(int i = 1; i <= Math.pow(20, signals.length); i++){
            
            int count = 0;
            
            for(int j = 0; j < signals.length; j++){
                if(isYellow(signals, j, i)) count++;
            }
            
            if(count >= signals.length){
                answer = i;
                break;
            }
        }
        
        return answer == 0 ? -1 : answer;
        
    }
    
    public boolean isYellow(int[][] signals, int index, int time){
        
        int cycle = signals[index][0] + signals[index][1] + signals[index][2];
        
        int rest = time % cycle;
        
        if(signals[index][0] < rest && rest <= (signals[index][0] + signals[index][1])){
            return true;
        }
        
        return false;
    }
    
}