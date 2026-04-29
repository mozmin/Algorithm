import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        // 기지국 하나가 커버하는 범위: 2 * w + 1
        int range = 0;
        int left = 0;
        int right = 0;
        for(int s : stations){
            
            right = s - w;
            
            range = right - left - 1;
            if(range >= 0) answer += cal(range, w);
            
            left = s + w;
        }
        
        if(left < n){
            range = n - left;
            answer += cal(range, w);
        }


        return answer;
    }
    
    public int cal(int range, int w){
        
        int value = range / (2*w+1);
        int rest = range % (2*w+1);
        
        if(rest > 0) value += 1;
        
        return value;
    }
}