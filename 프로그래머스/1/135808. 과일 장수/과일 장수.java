import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] arr = Arrays.stream(score)
                    .boxed()
                    .sorted((a, b) -> b.compareTo(a))
                    .mapToInt(Integer::intValue)
                    .toArray();

        int key = -1;
        for(int i = 0; i < arr.length / m; i++){
            key = key + m;
            answer = answer + (arr[key] * m);
        }
        
        return answer;
    }
}