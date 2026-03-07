import java.util.*;

class Solution {
    
    int answer;
    Deque<Integer> stack;
    public int solution(String dartResult) {
        answer = 0;
        
        stack = new ArrayDeque<>();
        
        String temp = "";
        for(int i = 0; i < dartResult.length(); i++){
        
            char c = dartResult.charAt(i);
            
            if(Character.isDigit(c)){
                temp += c;
            }else if(c == 'S' || c == 'D' || c == 'T'){
                int point = Integer.parseInt(temp);
                bonus(c, point);
                
                temp = "";
            }
            // 옵션
            else{
                option(c);
            }
            
        }
        // 스택에 남은 모든 점수 합산
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        
        
        return answer;
    }
    
    public void bonus(char c, int point){
        
        if(c == 'S'){
            stack.push((int) Math.pow(point, 1));
        }else if( c== 'D'){
            stack.push((int) Math.pow(point, 2));
        }else{
            stack.push((int) Math.pow(point, 3));
        }
    }
    
    public void option(char c){ 
        
        // 스타상
        if(c == '*'){
            
            int curPoint = stack.pop();
            if(!stack.isEmpty()){
                int exPoint = stack.pop();
                stack.push(exPoint * 2);
            }
            stack.push(curPoint * 2);        
        }
        else if(c == '#'){
            int curPoint = stack.pop();
            stack.push(-curPoint);
        }
    }
}