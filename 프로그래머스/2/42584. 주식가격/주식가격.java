import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        
        Deque<Integer> que = new ArrayDeque<>();
        
        for(int i = 0; i < prices.length; i++){
            
            while(!que.isEmpty() && prices[que.peek()] > prices[i]){
                int index = que.pop();
                answer[index] = i - index;
            }
            que.push(i);
        }
        
        // 남아있는 스텍들 정리
        while(!que.isEmpty()){
            
            int index = que.pop();
            answer[index] = prices.length - 1 - index;
        }

        return answer;
    }
}