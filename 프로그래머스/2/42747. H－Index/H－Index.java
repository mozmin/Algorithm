import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int arrLength = citations.length;
        
        // h 0 ~ 1000
        outer: for(int i = 0; i < arrLength; i++){
            
            int count = arrLength - i;
            
            if(citations[i] >= count){
                return count;
            }
        }
        return 0;
    }
}