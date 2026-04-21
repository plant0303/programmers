import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int arr : array){
            map.put(arr, map.getOrDefault(arr, 0) + 1);
        }
        
        int maxCount = Collections.max(map.values());
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(maxCount == entry.getValue()){
                count++;
                answer = entry.getKey();
            }
        }

        return (count > 1) ? -1 : answer;
    }
}