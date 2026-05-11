import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();

        // 0 ~ (m * 1000) 까지
        int index = 0;
        while(sb.length() <= (m * t)){
            String nxt = Integer.toString(index, n).toUpperCase();
            sb.append(nxt);
            //System.out.println("nxt: " + nxt);
            
            index++;
        }
        
        String value = sb.toString();
        
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < value.length(); i++){
            
            if(i % m == p-1 && result.length() < t){
                char c = value.charAt(i);
                //System.out.print("+");
                result.append(c);
            }
        }
        
        return result.toString();
    }
}