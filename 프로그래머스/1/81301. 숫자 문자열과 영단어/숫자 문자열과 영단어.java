import java.util.*;
class Solution {
    public int solution(String s) {
        ArrayList<String> list = new ArrayList<>();
            
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        String ch = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if (c-'0' >= 0 && c-'0' <= 9) {
                list.add(String.valueOf(c));
            } else {
                ch += c;
                
                if (map.containsKey(ch)) {
                    list.add(map.get(ch));
                    ch = "";
                }
            }
        }
            
        String[] stringList = list.toArray(new String[0]);
        String result = String.join("", stringList);
        int answer = Integer.parseInt(result); 
        return answer;
    }
}