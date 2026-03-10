import java.io.*;
import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
        
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 완주한 선수
        for(String c : completion){
            if(map.containsKey(c)) map.put(c, map.get(c) - 1);
        }
        
        for(String p : participant){
            if(map.get(p) >= 1) return p;
        }
        
        return "";
    }
}