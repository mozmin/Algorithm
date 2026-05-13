import java.util.*;

class Solution {
    
    int max;
    public int solution(int n, int infection, int[][] edges, int k) {
        
        max = Integer.MIN_VALUE;
        
        // 노드 초기화
        ArrayList<int[]>[] nodes = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            nodes[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            nodes[u].add(new int[]{v, edge[2]});
            nodes[v].add(new int[]{u, edge[2]});
        }
        
        // 감염 여부 및 방문 처리용
        boolean[] visited = new boolean[n+1];
        visited[infection] = true;
        
        // 분기 시작
        dfs(n, nodes, visited, 0, k);
        
        return max;
    }

    public void dfs(int n, ArrayList<int[]>[] nodes, boolean[] visited, int count, int k){
        
        // 만약 k만큼 돌았다면
        if(count >= k){
            int result = 0;
            for(boolean v : visited){
                if(v) result++;
            }
            
            max = Math.max(max, result);
            
            return;
        }
        
        // 경우의 수 (A, B, C) 분기점
        for(int i = 1; i <= 3; i++){
            
            // 새 분기점 전용 visited 배열
            boolean[] copy = new boolean[n+1];
            for(int j = 1; j <= n; j++){
                copy[j] = visited[j];
            }
            
            // pipe 확인, 얕은 복사 활용
            bfs(i, nodes, copy);
            
            // 다음 분기점, 얕은 복사 활용
            dfs(n, nodes, copy, count+1, k);
        }
        
        return;
        
    }
   
    public void bfs(int pipe, ArrayList<int[]>[] nodes, boolean[] visited){
        
        Deque<Integer> q = new ArrayDeque<>();
        
        // 감염된 노드들 큐에 삽입
        for(int i = 1; i < visited.length; i++){
            if(visited[i]) q.offer(i);
        }
        
        while(!q.isEmpty()){
            
            int curNode = q.poll();
            
            // curNode 인접 리스트 확인
            for(int[] n : nodes[curNode]){
                
                int nxtNode = n[0];
                int connectedPipe = n[1];
                
                // 만약 nxtNode 감염이 안된 상태(방문 상태)이고, connectedPipe가 열려있다면    
                if(!visited[nxtNode] && connectedPipe == pipe){
                    
                    // 큐에 추가 후 감염(방문 처리)
                    q.offer(nxtNode);
                    visited[nxtNode] = true;
                }
            }
        }
        
        return;
    }
    
}



