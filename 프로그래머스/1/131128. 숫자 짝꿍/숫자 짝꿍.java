import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        Map<Character, Integer> mapX = new HashMap<>();
        Map<Character, Integer> mapY = new HashMap<>();
        
        // 카운팅
        for(int i = 0; i < X.length(); i++){
            mapX.put(X.charAt(i), mapX.getOrDefault(X.charAt(i), 0) + 1);
        }
        
        for(int i = 0; i < Y.length(); i++){
            mapY.put(Y.charAt(i), mapY.getOrDefault(Y.charAt(i), 0) + 1);
        }
        
        // 교집합 구하기
        ArrayList<Integer> result = new ArrayList<>();
        for(Character key : mapX.keySet()){
            
            if(mapY.containsKey(key)){
                int count = Math.min(mapX.get(key), mapY.get(key));
                for(int i = 0; i < count; i++){
                    result.add(key - '0');
                }
            }
        
        }
        
        
        // 정렬
        result.sort(Comparator.reverseOrder());
        
        if(result.isEmpty()) return "-1";
        if(result.get(0) == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int r : result){
            sb.append(r);
        }

        return sb.toString();
    }
}