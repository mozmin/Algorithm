import java.util.*;

class Solution {
    
    int lowRank;
    int highRank;
    Set<Integer> set;
    int zeroCount;
    public int[] solution(int[] lottos, int[] win_nums) {
        
        lowRank = 0;
        highRank = 0;
        zeroCount = 0;
        set = new HashSet<>();
        
        // Set에 당첨 번호 저장
        for(int win : win_nums) set.add(win);
        
        for(int l : lottos){
            // 만약 추천번호 중에 당첨번호가 있다면 삭제
            if(set.contains(l)) set.remove(l);
            if(l == 0) zeroCount++;
        }
        
        // 최저점 계산
        lowRanking();
        
        // 최고점 계산
        if(lowRank == 1) return new int[]{lowRank, lowRank};
        else if(lowRank == 6 && zeroCount == 0) return new int[]{lowRank, lowRank};
        
        int count = 0;
        for(int l : lottos) if(l == 0) count++;
        highRank = set.size() - count + 1;
        
        return new int[]{highRank, lowRank};
    }
    
    public void lowRanking(){
        if(set.size() == 6 || set.size() == 5) lowRank = 6;
        else if(set.size() == 0) lowRank = 1;
        else{
            lowRank = set.size() + 1;
        }
    }

}