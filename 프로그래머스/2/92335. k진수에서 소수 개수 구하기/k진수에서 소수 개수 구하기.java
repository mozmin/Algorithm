import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        int answer = 0;
        
        // k진수로 변환하기
        Deque<String> que = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            que.push(String.valueOf(n % k));
            n = n / k;
        }
        
        while(!que.isEmpty()) sb.append(que.pop());
        String kValue = sb.toString();
        String[] kList = kValue.split("0");
        
        for(String kListValue : kList){
            
            if(kListValue.equals("")) continue;
            
            Long kValueLong = Long.parseLong(kListValue);
            
            if(isPrime(kValueLong) && check(kValueLong)) answer++;
        }
            
        return answer;
    }
    
    // 2부터 ~ sqrt(value) 까지 0으로 나누어지는지 검사
    // 나누어진다면 return false
    // 안나누어지면 return true
    public boolean isPrime(Long value){
        
        if(value == 1 || value == 0) return false;
        
        for(int i = 2; i <= Math.sqrt(value); i++){
            if(value % i == 0) return false;
        }
        
        return true;
    }
    
    // 문제 조건에 맞는 소수인지 판별
    public boolean check(Long value){
        
        // 0이 포함되어있는지
        String checkZero = String.valueOf(value);
        for(int i = 0; i < checkZero.length(); i++){
            if(checkZero.charAt(i) == '0') return false;
        }
        
        return true;
        
    }
}