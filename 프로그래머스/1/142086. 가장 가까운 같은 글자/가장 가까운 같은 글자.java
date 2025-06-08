import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> lastSeen = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(lastSeen.containsKey(ch)){
                answer[i] = i - lastSeen.get(ch);
            } else{
                answer[i] =- 1;
            }
            
            lastSeen.put(ch, i);
            
        }
        return answer;
    }
}