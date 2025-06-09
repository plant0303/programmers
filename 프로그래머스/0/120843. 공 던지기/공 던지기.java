class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int cnt = 0;
        int number = 0;
        while(cnt < k - 1){
            number += 2;
            cnt++;
            if(number >= numbers.length){
                number = number - numbers.length;
            }
        }
        answer = numbers[number];
        return answer;
    }
}