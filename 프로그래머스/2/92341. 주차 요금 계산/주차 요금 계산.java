import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        // 기록용 Map<>
        Map<String, Integer> map = new HashMap<>();
        
        // 총 누적 시간 기록 Map<>
        Map<String, Integer> result = new HashMap<>();
            
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int partTime = fees[2];
        int partFee = fees[3];
        
        // Map<>에 값 넣기
        for(int i = 0; i < records.length; i++){
            
            int HH = Integer.parseInt(records[i].substring(0, 2));
            int MM = Integer.parseInt(records[i].substring(3, 5));
            int curTime = HH * 60 + MM;
            
            String carNumber = records[i].substring(6, 10);
            String value = records[i].substring(11);
            
            if(value.equals("IN")){
                map.put(carNumber, curTime);
            }else if(value.equals("OUT")){
                int inTime = map.get(carNumber);
                result.put(carNumber, result.getOrDefault(carNumber, 0) + (curTime - inTime));
                map.remove(carNumber);
            }
        }
        
        // 남아있는 Map<> 값 처리
        int lastTime = 23 * 60 + 59;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + (lastTime - entry.getValue()));
        }
        
        // 정답 형태로 변환 + 정산
        int index = 0;
        int[][] resultFees = new int[result.size()][2];
        for(Map.Entry<String, Integer> entry : result.entrySet()){
            
            resultFees[index][0] = Integer.parseInt(entry.getKey());
            
            if(entry.getValue() <= defaultTime){
                resultFees[index][1] = defaultFee;
            }else{
                resultFees[index][1] = defaultFee + (int) Math.ceil((double) (entry.getValue() - defaultTime) / partTime) * partFee;
            }
            index++;
        }
        
        Arrays.sort(resultFees, Comparator.comparingInt((int[] a) -> a[0]));
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = resultFees[i][1];
        }
        return answer;
    }
}