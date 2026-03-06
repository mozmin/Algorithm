import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        
        // 신호등 배열 초기화
        ArrayList<String>[] list = new ArrayList[signals.length];
        
        for(int i = 0; i < signals.length; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < signals.length; i++){
            addListValue(list[i], signals[i][0], "G");
            addListValue(list[i], signals[i][1], "Y");
            addListValue(list[i], signals[i][2], "R");
        }
        
        for(int i = 0; i < signals.length; i++){
            for(int j = 0; j < list[i].size(); j++){
                System.out.print(list[i].get(j) + "|");
            }    
            
            System.out.println();
        }
        
        // 신호등 시뮬레이션
        int count;
        for(int i = 0; i < Math.pow(20, signals.length); i++){
            
            count = 0;
            for(ArrayList<String> l : list){
                if(isYellow(l, i)) count++;
            }    
            
            if(count == signals.length){
                answer = i + 1;
                break;
            }
        }
        
        if(answer == 0) return -1;
        
        return answer;
    }
    
    public boolean isYellow(ArrayList<String> list, int time){
        
        int index = time % list.size();
        
        if(list.get(index).equals("Y")) return true;
        
        return false;
    }
    
    public void addListValue(ArrayList<String> list, int count, String value){
        
        for(int i = 0; i < count; i++){
            list.add(value);
        }
    }
}