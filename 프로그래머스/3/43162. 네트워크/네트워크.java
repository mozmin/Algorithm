import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            
            if (!visited[i]) {
                bfs(i, n, computers, visited);
                answer++;
            }
        }

        return answer;
    }

    private void bfs(int start, int n, int[][] computers, boolean[] visited) {
        
        Deque<Integer> que = new ArrayDeque<>();
        
        que.offer(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int curNetwork = que.poll();

            for (int j = 0; j < n; j++) {

                if (computers[curNetwork][j] == 1 && !visited[j] && j != curNetwork) {
                    que.offer(j);    
                    visited[j] = true;
                }
            }
        }
    }
}