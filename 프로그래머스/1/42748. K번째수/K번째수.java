import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int[] command: commands){
            int[] cut = new int[command[1] - command[0] + 1];
            for(int a = command[0]-1; a <= command[1]-1; a++) cut[a-(command[0]-1)] = array[a];
            
            Arrays.sort(cut);
            result.add(cut[command[2]-1]);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}