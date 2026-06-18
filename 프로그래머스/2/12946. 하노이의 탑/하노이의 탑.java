import java.util.*;

class Solution {
    // 이동 경로를 순서대로 저장할 리스트
    ArrayList<int[]> result = new ArrayList<>();
    
    public int[][] solution(int n) {

        hanoi(n, 1, 3, 2);
        
        return result.toArray(new int[result.size()][]);
    }
    
    private void hanoi(int n, int from, int to, int empty) {

        if (n == 1) {
            result.add(new int[]{from, to});
            return;
        }

        hanoi(n - 1, from, empty, to);
        
        result.add(new int[]{from, to});

        hanoi(n - 1, empty, to, from);
    }
}