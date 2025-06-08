class Solution {
    public int[] solution(String s) {
        String[] arr = s.split("");
        int[] answer = new int[s.length()];
        
        for(int i = 0; i < arr.length; i++){
            answer[i] = -1;
            for(int j = i - 1; j >= 0; j--){
                if(arr[i].equals(arr[j])){
                    int ans = i - j;
                    answer[i] = ans;
                    break;
                }
                
                if(j == 0){
                    answer[i] = -1;
                }
            }
        }
        return answer;
    }
}