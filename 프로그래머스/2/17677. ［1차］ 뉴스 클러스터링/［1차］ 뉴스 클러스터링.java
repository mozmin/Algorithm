import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
class Solution {
    
    public int solution(String str1, String str2) {
        
        Map<String, Integer> mapStr1 = new HashMap<>();
        Map<String, Integer> mapStr2 = new HashMap<>();
        
        // 모두 대문자로 변환
        String upperStr1 = str1.toUpperCase();
        String upperStr2 = str2.toUpperCase();

        // 2글자씩 변환
        for(int i = 0; i < upperStr1.length()-1; i++){
            String value = upperStr1.substring(i, i+2);
            if(check(value)) {
                mapStr1.put(value, mapStr1.getOrDefault(value, 0) + 1);
            }
        }
        
        for(int i = 0; i < upperStr2.length()-1; i++){
            String value = upperStr2.substring(i, i+2);
            if(check(value)) {
                mapStr2.put(value, mapStr2.getOrDefault(value, 0) + 1);
            }
        }
        
        // map을 통해 교집합 계산
        int same = 0;
        for(String key : mapStr1.keySet()){
            same += Math.min(mapStr1.getOrDefault(key, 0), mapStr2.getOrDefault(key, 0));
        }
        
        // 합집합 계산
        
        int str1Count = 0;
        for(int i : mapStr1.values()) str1Count += i;
        
        int str2Count = 0;
        for(int i : mapStr2.values()) str2Count += i;
        
        int union = str1Count + str2Count - same;
        
        if(union == 0) return 65536;
        double jaccard = (double) same / union;
        return (int) (jaccard * 65536);
    }
    
    public boolean check(String value){
        
        char c1 = value.charAt(0);
        char c2 = value.charAt(1);
        
        if('A' <= c1 && c1 <= 'Z' && 'A' <= c2 && c2 <= 'Z') return true;
        
        return false;
    }
}