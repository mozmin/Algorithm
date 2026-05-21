import java.util.*;

class Solution {
    
    int[] discount = {10, 20, 30, 40};
    
    int maxJoin = 0;
    int maxSales = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] curChoiceSalesPercent = new int[emoticons.length];
        
        dfs(0, curChoiceSalesPercent, users, emoticons);
        
        return new int[]{maxJoin, maxSales};
    }
    
    public void dfs(int count, int[] curChoice, int[][] users, int[] emoticons){
        
        // 만약 count가 이모티콘 갯수와 동일하다면 -> user 계산
        if(count == emoticons.length){
            calculate(curChoice, users, emoticons);
            return;
        }
        
        // 모든 할인율 조합을 시도하며 dfs 호출
        for(int i = 0; i < discount.length; i++) {
            curChoice[count] = discount[i];
            dfs(count + 1, curChoice, users, emoticons);
        }
    }
    
    // 유저별 구매 금액과 플러스 가입 여부를 계산하는 헬퍼 메서드
    private void calculate(int[] curChoice, int[][] users, int[] emoticons) {
        int currentJoin = 0;
        int currentSales = 0;
        
        for(int[] user : users) {
            int userMinDiscount = user[0]; 
            int userMaxBudget = user[1];   
            
            int totalSpent = 0;
            
            // 현재 할인율 조합으로 이모티콘 구매액 계산
            for(int i = 0; i < emoticons.length; i++) {
                if(curChoice[i] >= userMinDiscount) {
                    // 할인된 가격 계산
                    totalSpent += emoticons[i] * (100 - curChoice[i]) / 100;
                }
            }
            
            // 예산 이상을 썼다면 구매를 모두 취소하고 플러스 가입
            if(totalSpent >= userMaxBudget) {
                currentJoin++;
            } else {
                // 예산 미만이면 판매액에 누적
                currentSales += totalSpent;
            }
        }
        
        
        if(currentJoin > maxJoin) {
            maxJoin = currentJoin;
            maxSales = currentSales;
        } else if(currentJoin == maxJoin) {
            if(currentSales > maxSales) {
                maxSales = currentSales;
            }
        }
    }
}