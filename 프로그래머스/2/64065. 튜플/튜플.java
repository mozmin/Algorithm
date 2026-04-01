import java.util.*;

class Solution {
    public int[] solution(String s) {

        String[] groups = s.substring(2, s.length() - 2).split("\\}\\,\\{");

        // 길이를 기준으로 오름차순 정렬
        Arrays.sort(groups, (a, b) -> a.length() - b.length());

        int[] answer = new int[groups.length];
        Set<Integer> set = new HashSet<>();
        int index = 0;

        // 각 집합을 순회하며 새로운 숫자를 answer에 담기
        for (String group : groups) {
            String[] nums = group.split(",");
            for (String numStr : nums) {
                int num = Integer.parseInt(numStr);
                
                // set에 없다면
                if (!set.contains(num)) {
                    set.add(num);
                    answer[index++] = num;
                    break;
                }
            }
        }

        return answer;
    }
}