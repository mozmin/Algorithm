import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.offer(s);
        }
        
        while(true){
            
            if(pq.peek() >= K) break;
            
            if(pq.size() >= 2){
                int first = pq.poll();
                int second = pq.poll();
                
                int newScoville = first + (second * 2);
            
                pq.offer(newScoville);
                
                answer++;
            }else{
                return -1;
            }
            
        }
        
        return answer;
    }
}