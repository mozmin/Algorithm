import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1. 요청 시간 순으로 정렬 (먼저 온 작업을 확인하기 위함)
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 2. 소요 시간 순으로 우선순위 큐 설정 (SJF 핵심)
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int totalResponseTime = 0;
        int time = 0;      // 현재 시간
        int index = 0;     // jobs 배열 인덱스
        int count = 0;     // 완료된 작업 수

        // 모든 작업을 처리할 때까지 반복
        while (count < jobs.length) {
            
            // 현재 시간(time) 이전에 들어온 모든 요청을 큐에 삽입
            while (index < jobs.length && jobs[index][0] <= time) {
                que.add(jobs[index]);
                index++;
            }

            if (que.isEmpty()) {
                // 큐가 비어있다면, 다음 작업의 요청 시점으로 시간 점프
                time = jobs[index][0];
            } else {
                // 소요 시간이 가장 짧은 작업 수행
                int[] job = que.poll();
                // 대기 시간 + 소요 시간 = (현재 시간 - 요청 시간) + 소요 시간
                // 즉, 완료 시점(time + job[1]) - 요청 시점(job[0])
                totalResponseTime += (time + job[1]) - job[0];
                time += job[1];
                count++;
            }
        }

        return totalResponseTime / jobs.length;
    }
}