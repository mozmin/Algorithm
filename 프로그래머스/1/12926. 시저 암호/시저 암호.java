import java.util.*;

class Solution {
    public String solution(String s, int n) {
        
        StringBuilder sb = new StringBuilder();       
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            // 대문자
            if(c >= 'A' && c <= 'Z'){
                c += n;
                
                if(c > 'Z'){
                    c -= 26;
                    sb.append(c);
                }else{
                    sb.append(c);
                }
            }
            else if(c >= 'a' && c <= 'z'){
                c += n;
                
                if(c > 'z'){
                    c -= 26;
                    sb.append(c);
                }else{
                    sb.append(c);
                }
            }else{
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}