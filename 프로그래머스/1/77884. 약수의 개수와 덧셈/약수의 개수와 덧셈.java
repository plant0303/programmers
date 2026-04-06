class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int cnt = 0;
            for(int j = 1; j <= i; j++){
                if(i % j == 0){
                    cnt++;
                }    
            }
            if(cnt % 2 == 0){
                // cnt가 짝수일 경우
                answer += i;
            } else {
                // cnt가 홀수일 경우
                answer -= i;
            }
        }
        return answer;
    }
}