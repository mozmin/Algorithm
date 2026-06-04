class Solution {
    
    public long solution(int n) {
        
        if(n == 1) return 1;
        else if(n == 2) return 2;
        
        long result = 0;
        
        // 점화식: dp(n) = dp(n-1) + dp(n-2)
        int[] dist = new int[n+1];
        
        dist[1] = 1;
        dist[2] = 2;
        
        if(n <= 2) return dist[n];
        else{
            for(int i = 3; i <= n; i++){
                dist[i] = (dist[i-1] + dist[i-2]) % 1234567;
            }
        }
        
        return dist[n];
    }

}