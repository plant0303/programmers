import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> minMap = new HashMap<>();
        
        for(String keys : keymap){
            for(int i = 0; i < keys.length(); i++){
                char alphabet = keys.charAt(i);
                int count = i + 1;
                minMap.put(alphabet, Math.min(minMap.getOrDefault(alphabet, 101), count));
            }
        }
        
        
        for(int i = 0; i < targets.length; i++){
            int count = 0;
            for(char target : targets[i].toCharArray()){
                if(minMap.containsKey(target)){
                    count += minMap.get(target);
                } else {
                    count = -1;
                    break;
                }
            }
            answer[i] = count;
            
        }
        return answer;
    }
}