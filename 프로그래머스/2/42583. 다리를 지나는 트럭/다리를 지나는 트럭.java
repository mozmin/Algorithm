import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Deque<int[]> q = new ArrayDeque<>();
        int time = 0;
        int curWeight = 0;
        
        for(int truck : truck_weights){
            
            while (true) {
                
                // 1. 큐가 비어있다면
                if (q.isEmpty()) {
                    time++; // 다리에 올라가면서 1초 소요
                    curWeight += truck;
                    q.offer(new int[]{truck, time + bridge_length});
                    break; // 무사히 올렸으니 while문을 깨고 다음 대기 트럭으로!
                }
                
                // 2. 다리가 꽉 찬 경우 (문제의 bridge_length만큼 트럭이 올라간 경우)
                else if (q.size() == bridge_length) {
                    int[] firstTruck = q.poll();
                    curWeight -= firstTruck[0]; // 맨 앞 트럭 무게만 차감
                }
                
                // 3. 다리에 빈자리는 있지만, 다음 트럭 무게를 못 견디면 -> 꺼내면서 시간 점프
                else if (curWeight + truck > weight) {
                    int[] firstTruck = q.poll();
                    curWeight -= firstTruck[0];
                    
                    // 맨 앞 트럭이 빠져나가는 시간으로 현재 시간을 점프!
                    // (-1을 해주는 이유는, 다음 루프를 돌면서 새 트럭이 들어갈 때 time++ 이 되기 때문입니다)
                    time = Math.max(time, firstTruck[1] - 1); 
                }
                
                // 4. 빈자리도 있고, 남은 무게도 넉넉하다면
                else {
                    time++; // 다리에 올라가면서 1초 소요
                    curWeight += truck;
                    q.offer(new int[]{truck, time + bridge_length});
                    break;
                }
            }
            
        }
        
        return time + bridge_length;
    }
}