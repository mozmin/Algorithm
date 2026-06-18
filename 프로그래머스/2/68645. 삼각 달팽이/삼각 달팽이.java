class Solution {
    public int[] solution(int n) {
        
        int lastPoint = (n * (n+1)) / 2;
        int[][] snail = new int[n+1][n+1];
        int[] answer = new int[lastPoint];
        
        int row = 0;
        int col = 1;
        int start = 1;
        // 방향 전환을 n번 수행
        for(int i = 1; i <= n; i++){
            
            // 이동거리가 갈수록 -1씩 줄어들음
            for(int j = i; j <= n; j++){
                
                // 첫번째 방향
                if(i % 3 == 1){
                    row++;
                }
                // 두번째 방향
                else if(i % 3 == 2){
                    col++;
                }
                // 세번째 방향
                else if(i % 3 == 0){
                    row--;
                    col--;
                }
                snail[row][col] = start++;
            }
        }
        
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) { // 삼각형 모양만큼만 돌기
                answer[index++] = snail[i][j];
            }
        }
            
        return answer;
    }
}