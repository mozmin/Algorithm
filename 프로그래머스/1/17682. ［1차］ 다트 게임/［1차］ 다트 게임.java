import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        Deque<Integer> q = new ArrayDeque<>();
        
        String split = "";

        for(int i = 0; i < dartResult.length(); i++){
            
            char c = dartResult.charAt(i);
            
            // 숫자가 나오면 컷
            if(c - '0' >= 0 && c - '0' <= 9){
                
                // 만약 1이면 다음 숫자가 0인지 검사
                if(c - '0' == 1){
                    char nxt = dartResult.charAt(i+1);
                    
                    if(nxt == '0'){
                        if(!split.isEmpty()) cal(split, q);
                    
                        split = String.valueOf(c);
                        split += String.valueOf(nxt);
                        
                        ++i;
                    }else{
                        if(!split.isEmpty()) cal(split, q);
                    
                        split = String.valueOf(c);
                    }
                    

                }else{
                    // 계산
                    if(!split.isEmpty()) cal(split, q);
                
                    // split 초기화
                    split = String.valueOf(c);   
                }
            }
            
            // 숫자가 아니라면 그냥 +
            else{
                split += String.valueOf(c);
            }
        }
        
        // 마지막 남은 split 처리
        cal(split, q);
        
        // 점수 계산
        while(!q.isEmpty()){
            
            System.out.println(q.peek());
            answer += q.pop();
        }
        
        return answer;
    }
    
    private void cal(String split, Deque<Integer> q){
        
        int total = 0;
        int point = 0;
        char bonus =  ' ';
        char option = ' ';
        
        if(split.charAt(0) - '0' == 1 && split.charAt(1) - '0' == 0){
            point = 10;
            bonus = split.charAt(2);
            option = split.length() != 4 ? ' ' : split.charAt(3);
        }else{
            point = (int) (split.charAt(0) - '0');
            bonus = split.charAt(1);
            option = split.length() != 3 ? ' ' : split.charAt(2);
        }
            
        // 보너스 확인
        if(bonus == 'S') total = (int) Math.pow(point, 1);
        else if(bonus == 'D') total = (int) Math.pow(point, 2);
        else if(bonus == 'T') total = (int) Math.pow(point, 3);

        
        // 옵션 확인
        if(option != ' '){
            
            // 본인과 이전 값 x2
            if(option == '*'){
                
                if(!q.isEmpty()){
                    int prev = q.poll();
                    q.push(2 * prev);
                }
                
                total = 2 * total;
            }
            // 본인 점수 x-1
            else if(option == '#'){
                total = -1 * total;
            }
        }
        
        q.push(total);
    }
}




