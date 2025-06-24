class Solution {
    public int solution(int[] numbers) {
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < numbers.length; i++){
            int num1 = numbers[i];
            for(int j = i - 1; j >= 0; j--){
                max = max > num1 * numbers[j] ? max : num1 * numbers[j];
            }
        }
        return max;
    }
}