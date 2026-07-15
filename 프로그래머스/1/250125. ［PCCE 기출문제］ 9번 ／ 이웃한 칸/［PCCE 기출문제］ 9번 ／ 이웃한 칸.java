class Solution {
    
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int n = board.length;
        String color = board[h][w];
        
        for(int i = 0; i < 4; i++){
            int ny = h + dy[i];
            int nx = w + dx[i];
            
            if(ny >= 0 && nx >= 0 && ny < n && nx < n && board[ny][nx].equals(color)) answer++;
        }
        return answer;
    }
}