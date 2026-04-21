class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int rest = n;
        while(rest >= a){
            int bundles = a * (rest / a); // 제출한 병 개수
            int newBottle = (rest / a) * b; // 돌려받은 병 개수
            answer += newBottle;
            rest = (rest - bundles) + newBottle; // 남은 병 개수
        }
        
        return answer;
    }
}