class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int result = 0;
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    result = nums[i] + nums[j] + nums[k];

                    if(isPrime(result)){
                        answer++;
                    }
                
                }
            }
        }
        return answer;
    }
    
    public boolean isPrime(int result){
        for(int i = 2; i < result; i++){
            if(result % i == 0){
                return false;
            }
        }
        return true;
    }
}