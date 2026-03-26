class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 1; i <= yellow/2 + 1; i++){
            
            // 세로: i
            if(yellow % i == 0){
                int row = yellow / i; // 가로: yellow / i
                
                int checkBrown = (row * 2) + (i * 2) + 4;
                if(checkBrown == brown){
                    answer[0] = row + 2;
                    answer[1] = i + 2;
                    break;
                }
            }
        }
        return answer;
    }
}