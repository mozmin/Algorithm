import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        double[][] answer = new double[N][2];
        
        for(int i = 0; i < stages.length; i++){
            
            int s = stages[i] - 1;
            
            if(s == N) continue;
            answer[s][1]++;
        }
        
        double sum = (double) stages.length;
        for(int i = 0; i < answer.length; i++){
            // 스테이지 i 실패율
            answer[i][0] = i+1;
            
            double fail = (sum == 0 ? 0 : (double) answer[i][1] / sum);
            
            System.out.println(answer[i][1] + "/" + sum + "=" + fail);
            
            sum -= answer[i][1];
            answer[i][1] = fail;
        }
        for(double[] i : answer){
            System.out.println(i[1] + " | ");
        }
        
        Arrays.sort(answer, Comparator.comparingDouble((double[] a) -> a[1]).reversed()
                    .thenComparingDouble((double[] a) -> a[0]));
        
        int[] result = new int[N];
        for(int i = 0; i < answer.length; i++){
            result[i] = (int) answer[i][0];
        }
        return result;
    }
}