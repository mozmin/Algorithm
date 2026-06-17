import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n+1];
        
        // 도난 당한 학생 정리
        for(int l : lost){
            student[l]++;
        }
        
        for(int r : reserve){
            student[r]--;
        }
        
        
        // 앞번호 우선
        for(int i = 1; i <= n; i++){
            
            if(i-1 > 0 && student[i] == 1 && student[i-1] == -1){
                student[i-1]++;
                student[i]--;
            }
            else if(i+1 <= n && student[i] == 1 && student[i+1] == -1){
                student[i+1]++;
                student[i]--;
            }
        }
        
        // 0인 학생 갯수
        for(int i = 1; i <= n; i++){
            if(student[i] <= 0) answer++;
        }  
            
        return answer;
    }
}