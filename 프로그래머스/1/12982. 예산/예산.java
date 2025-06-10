import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int cnt = 0;
        int[] arr = Arrays.stream(d).sorted().toArray();
        
        for(int i = 0; i < arr.length; i++){
            if(answer + arr[i] > budget){
                break;
            }
            answer += arr[i];
            cnt++;
        }
        return cnt;
    }
}