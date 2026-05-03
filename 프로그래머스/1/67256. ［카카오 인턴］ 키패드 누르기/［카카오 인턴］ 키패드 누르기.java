import java.util.*;

class Solution {
    
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    public String solution(int[] numbers, String hand) {
        ArrayList<String> result = new ArrayList<>();
        
        HashMap<Integer, int[]> map = new HashMap<>();
        
        String defaultHand = hand.equals("right") ? "R" : "L";
        
        int index = 1;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(index == 11) map.put(0, new int[]{i, j});
                else{
                    map.put(index, new int[]{i, j});
                }
                index++;
            }
        }
        
        int[] left = new int[]{3, 0};
        int[] right = new int[]{3, 2};
        for(int number : numbers){
            
            if(number == 1 || number == 4 || number == 7){
                result.add("L");
                int[] pos = map.get(number);
                left[0] = pos[0];
                left[1] = pos[1];
            }
            else if(number == 3 || number == 6 || number == 9){
                result.add("R");
                int[] pos = map.get(number);
                right[0] = pos[0];
                right[1] = pos[1];
            }
            else{
                int[] targetPos = map.get(number);
                
                String touch = "";
                if(bfs(left, targetPos[0], targetPos[1]) == bfs(right, targetPos[0], targetPos[1])){
                    result.add(defaultHand);
                    touch = defaultHand;
                }
                else{
                    String value = bfs(left, targetPos[0], targetPos[1]) < bfs(right, targetPos[0], targetPos[1]) ? "L" : "R";
                    result.add(value);
                    touch = value;
                }
                
                if(touch.equals("L")){
                    left[0] = targetPos[0];
                    left[1] = targetPos[1];
                }else{
                    right[0] = targetPos[0];
                    right[1] = targetPos[1];
                }
            }
        }
        
        String[] resultList = result.stream().map(i -> i).toArray(String[]::new);
        
        return String.join("", resultList);
    }
    
    public int bfs(int[] pos, int targetY, int targetX){
        return Math.abs(pos[0] - targetY) + Math.abs(pos[1] - targetX);
    }
}








