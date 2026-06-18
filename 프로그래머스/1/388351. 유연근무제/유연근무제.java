import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        // 희망 출근시간
        int[] converted = new int[schedules.length];
        for(int i = 0; i < schedules.length; i++){
            int minute = (schedules[i] % 100) + 10;
            
            if(minute >= 60){
                if(schedules[i] / 100 == 23){
                    converted[i] = minute-60; 
                }else{
                    converted[i] = ((schedules[i] / 100) * 100) + 100 + (minute-60); 
                }
            }else{
                converted[i] = ((schedules[i] / 100) * 100) + minute; 
            }
        }

        // 지각 여부 판단
        // timelogs.length -> n명
        for(int i = 0; i < timelogs.length; i++){
            
            // 일주일
            int count = 0;
            for(int j = 0; j < 7; j++){
                
                int d = (startday + j) % 7;
                
                // 주말은 패스
                if(d == 6 || d == 0) continue;
                
                // 만약 출근시간을 지키 못했다면,
                if(timelogs[i][j] > converted[i]) break;
                
                count++;
            }
            
            if(count >= 5) answer++;
        }
        
        return answer;
    }
}