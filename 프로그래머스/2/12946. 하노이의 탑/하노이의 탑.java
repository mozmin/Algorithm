import java.util.*;

class Solution {
    // 이동 경로를 순서대로 저장할 리스트
    ArrayList<int[]> result = new ArrayList<>();
    
    public int[][] solution(int n) {
        // n개의 원판을 1번 기둥에서 3번 기둥으로 옮긴다 (2번 기둥을 경유지로 사용)
        hanoi(n, 1, 3, 2);
        
        // ArrayList<int[]>를 int[][] 2차원 배열로 변환하여 반환
        return result.toArray(new int[result.size()][]);
    }
    
    // 재귀 함수: n개의 원판을 from에서 to로 옮김 (empty를 경유해서)
    private void hanoi(int n, int from, int to, int empty) {
        // [기저 조건] 원판이 1개뿐이라면 대피시킬 필요가 없으므로
        // 규칙을 위반할 일이 없습니다. 바로 목적지로 옮기고 종료합니다.
        if (n == 1) {
            result.add(new int[]{from, to});
            return;
        }
        
        // 1단계: 맨 밑의 큰 원판을 움직이기 위해, 위의 n-1개 원판을 경유지(empty)로 대피시킵니다.
        // (목적지 기둥인 to를 대피 보조용으로 사용하므로 기둥 순서가 from -> empty가 됩니다.)
        hanoi(n - 1, from, empty, to);
        
        // 2단계: 방해물이 사라졌으므로 맨 밑의 가장 큰 원판 1개를 목적지(to)로 옮깁니다.
        result.add(new int[]{from, to});
        
        // 3단계: 경유지(empty)에 대피해 있던 n-1개의 원판들을 다시 목적지(to)로 가져옵니다.
        // (이때 바닥에는 이미 가장 큰 원판이 깔려있으므로, 그 위에는 어떤 원판이 올라와도 규칙에 위배되지 않습니다.)
        hanoi(n - 1, empty, to, from);
    }
}