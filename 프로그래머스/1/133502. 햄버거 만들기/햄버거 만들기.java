import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        int[] hamburger = new int[ingredient.length];
        
        // 0. 인덱스 초기화
        int index = 0;
        
        // 1. ingredient 반복
        for(int i : ingredient){
            
            // 2. 재료 넣기
            hamburger[index++] = i;
            
            // 3. 4번째부터는 햄버거 완성이 되는지 검사
            if(index >= 4
              && hamburger[index-1] == 1 // 빵
              && hamburger[index-2] == 3 // 고기
              && hamburger[index-3] == 2 // 야채
              && hamburger[index-4] == 1 // 빵
            ) { 
                answer++;
                index -= 4;
            }
        }
        
        return answer;
    }
}