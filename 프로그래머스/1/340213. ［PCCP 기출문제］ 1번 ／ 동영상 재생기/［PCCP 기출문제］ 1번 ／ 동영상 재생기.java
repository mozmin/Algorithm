import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int video_len_int = (Integer.parseInt(video_len.substring(0, 2)) * 60) + Integer.parseInt(video_len.substring(3, 5));
        int pos_int = (Integer.parseInt(pos.substring(0, 2)) * 60) + Integer.parseInt(pos.substring(3, 5));
        int op_start_int = (Integer.parseInt(op_start.substring(0, 2)) * 60) + Integer.parseInt(op_start.substring(3, 5));
        int op_end_int = (Integer.parseInt(op_end.substring(0, 2)) * 60) + Integer.parseInt(op_end.substring(3, 5));
        
        for(String c : commands){
            
            // 오프닝 조건
            if(op_start_int <= pos_int && pos_int <= op_end_int) pos_int = op_end_int;
            
            // 10초 후
            // 비디오 길이를 넘는다면 비디오 길이로 이동
            // 비디오 길이 안에있다면 10초 후로 이동
            if(c.equals("next")){
                if(pos_int + 10 >= video_len_int) pos_int = video_len_int;
                else if(pos_int + 10 < video_len_int) pos_int += 10;
            }
            // 10초 전
            // 0초보다 작다면 0초로 이동
            // 0초보다 크다면 10초 전으로 이동
            else if(c.equals("prev")){
                if(pos_int - 10 <= 0) pos_int = 0;
                else if(pos_int - 10 > 0) pos_int -= 10;
            }
        }
        
        // 오프닝 조건
        if(op_start_int <= pos_int && pos_int <= op_end_int) pos_int = op_end_int;

        int minute = pos_int / 60;
        int second = pos_int % 60;
        
        answer = String.format("%02d:%02d", minute, second);
        return answer;
    }
}