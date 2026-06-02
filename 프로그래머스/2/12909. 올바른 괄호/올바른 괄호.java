import java.util.*;
class Solution {
    boolean solution(String s) {

        Deque<Character> q = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            if(c == '(') q.push(c);
            else if(c == ')'){
                if(q.isEmpty()) return false;
                q.pop();
            }
        }

        return q.isEmpty();
    }
}