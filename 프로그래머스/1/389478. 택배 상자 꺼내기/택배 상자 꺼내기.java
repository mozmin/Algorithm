import java.util.*;

class Solution {
    

    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int v = (int) Math.ceil((double) n / (double) w);
        int[][] boxes = new int[v][w];
        for(int[] b : boxes) Arrays.fill(b, 0);
        
        
        // 꺼낼 박스 좌표
        int y = 0;
        int x = 0;
        
        // false -> 왼쪽에서 오른쪽으로 정방향
        // true - > 오른쪽에서 왼쪽으로 역방향
        boolean switchBox = false;
        
        // 박스 채우기
        int index = 1;
        for(int i = 0; i < v; i++){
            
            // 정방향
            if(index <= n && !switchBox){
                for(int j = 0; j < w; j++){
                    if(index <= n){
                        boxes[i][j] = index;
                        if(index == num){
                            y = i;
                            x = j;
                        }
                        index++;
                    }
                }
                switchBox = true;
            }
            // 역방향
            else if(switchBox){
                for(int j = w-1; j >= 0; j--){
                    if(index <= n){
                        boxes[i][j] = index;
                        if(index == num){
                            y = i;
                            x = j;
                        }
                        index++;
                    }
                }
                switchBox = false;
            }
        }
        
        //System.out.println("y: " + y + " | x: " + x);
        
        // 상자꺼내기
        while(y < v){
            if(boxes[y][x] != 0) answer++;
            y++;
        }
        
        return answer;
    }
}