import java.util.*;

class Solution {
    int answer = 0;
    int n;
    int[][] queries;
    int[] expectedAnswers;
    int[] picked = new int[5]; // 현재 선택한 5개의 숫자 저장

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.queries = q;
        this.expectedAnswers = ans;

        // DFS 시작 1번 숫자부터
        dfs(1, 0);

        return answer;
    }

    private void dfs(int num, int count) {
        
        // 5개를 모두 선택한 경우
        if (count == 5) {
            if (check()) answer++;
            return;
        }

        // n 이상이어서 자를 더 이상 고를 수 없는 경우
        if (num > n) return;
        
        // 현재 숫자(num)를 선택하지 않고 다음 숫자로 넘어가는 경우
        dfs(num + 1, count);

        // 현재 숫자를 선택하는 경우
        picked[count] = num;
        dfs(num + 1, count + 1);
    }

    private boolean check() {
        for (int i = 0; i < queries.length; i++) {
            
            int matchCount = 0;
            
            for (int p : picked) {
                for (int target : queries[i]) {
                    
                    if (p == target) {
                        matchCount++;
                        break;
                    }
                }
            }
            
            // 하나라도 조건이 다르면 false 반환
            if (matchCount != expectedAnswers[i]) {
                return false;
            }
        }
        return true;
    }
}