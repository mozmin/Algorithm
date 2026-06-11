import java.util.*;

class Solution {
    public int solution(String[][] book_time) {

        int m = book_time.length;
        int n = book_time[0].length;
        
        int[][] book_time_int = new int[m][n];
         
        for(int i = 0; i < m; i++){
            int[] convertedTime = converTime(book_time[i]);
                
            book_time_int[i][0] = convertedTime[0];
            book_time_int[i][1] = convertedTime[1];
        }
        
        // 입실시간 기준 정렬
        Arrays.sort(book_time_int, Comparator.comparingInt((int[] a) -> a[0]));
        
        // 퇴실시간 기준
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int[] b : book_time_int){
            q.offer(b[1]);
        }
        
        for(int[] b : book_time_int){
            int ASAP = q.peek();
            
            // 현재 방문한 손님에게 내어드릴 방이 있는지 확인
            
            // 방이 있다면
            if(ASAP + 10 <= b[0]){
                q.poll();
            }
        }
        
        return q.size();
    }
    
    public int[] converTime(String[] time){
        
        String[] checkIn = time[0].split(":");
        String[] checkOut = time[1].split(":");
        
        int checkInt_int = (Integer.parseInt(checkIn[0]) * 60) + Integer.parseInt(checkIn[1]);
        int checkOut_int = (Integer.parseInt(checkOut[0]) * 60) + Integer.parseInt(checkOut[1]);
        
        return new int[]{checkInt_int, checkOut_int};
    }
}