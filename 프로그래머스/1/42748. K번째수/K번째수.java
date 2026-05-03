import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int[] command: commands){
            ArrayList<Integer> cut = new ArrayList<>();
            for(int i = command[0]; i <= command[1]; i++){
                cut.add(array[i-1]);
            }
            int[] split = cut.stream().mapToInt(Integer::intValue).toArray();
            
            Arrays.sort(split);
            result.add(split[command[2]-1]);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}