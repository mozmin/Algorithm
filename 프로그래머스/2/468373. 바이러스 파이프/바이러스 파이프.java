import java.util.*;

class Solution {
    
    int max;
    public int solution(int n, int infection, int[][] edges, int k) {
        
        max = Integer.MIN_VALUE;
        
        // 초기화
        ArrayList<int[]>[] nodes = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            nodes[i] = new ArrayList<>();
        }
        
        // nodes[from] = new int[]{to, pipe}
        // nodes[to] = new int[]{from, pipe}
        for(int[] edge : edges){
            nodes[edge[0]].add(new int[]{edge[1], edge[2]});
            nodes[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        
        // 감염여부 및 방문 처리용
        boolean[] visited = new boolean[n+1];
        visited[infection] = true;
        
        dfs(n, nodes, visited, k);
        
        return max;
    }

    public void dfs(int n, ArrayList<int[]>[] nodes, boolean[] visited, int k){
        
        // 만약 k 횟수를 모두 소진한다면
        if(k <= 0){
            int count = 0;
            
            for(int i = 1; i <= n; i++){
                if(visited[i]) count++;
            }
            
            max = Math.max(max, count);
            return;
        }
        
        // 분기처리 A, B C
        for(int i = 1; i <= 3; i++){
            
            // 깊은 복사를 위해 visited 배열 복사
            boolean[] copyVisited = new boolean[n+1];
            for(int j = 1; j <= n; j++){
                copyVisited[j] = visited[j];
            }
            
            // 먼저 bfs()로 파이프 작업을 한 후 다음 dfs()로 분기처리
            bfs(i, nodes, copyVisited);
            
            dfs(n, nodes, copyVisited, k-1);

        }
        
        return;
    }
   
    public void bfs(int pipe, ArrayList<int[]>[] nodes, boolean[] visited){
        
        // 큐 선언
        Deque<Integer> q = new ArrayDeque<>();
        
        // 감염된 노드들 모두 큐에 offer
        for(int i = 1; i < visited.length; i++){
            if(visited[i]) q.offer(i);
        }
        
        while(!q.isEmpty()){
            
            int curNode = q.poll();
            
            // 현재 방문중인 노드와 연결된 노드들 확인
            for(int[] node : nodes[curNode]){
                
                // 만약 연결된 노드가 감염이 안되어있고, pipe가 열려있다면
                if(!visited[node[0]] && node[1] == pipe){
                    q.offer(node[0]);
                    visited[node[0]] = true;
                }
            }
        }
        
        return;
        
    }
        
        
    
}



