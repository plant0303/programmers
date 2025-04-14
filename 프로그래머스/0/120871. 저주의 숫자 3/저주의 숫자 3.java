class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        while(cnt < n){
            answer++;
            if(String.valueOf(answer).contains("3") || answer % 3 == 0){
                continue;
            }
            cnt++;
        }

        return answer;
    }
}