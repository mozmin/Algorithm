import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[1]));
        
        for(int[] t : targets) q.offer(t);
        
        int lastPoint = 0;
        
        // 큐에서 값을 꺼내고, last 값 갱신
        while(!q.isEmpty()){
            
            int[] poll = q.poll();
            
            if(lastPoint <= poll[0]){
                lastPoint = poll[1];
                answer++;
            }
        }
        
        return answer;
    }
}








