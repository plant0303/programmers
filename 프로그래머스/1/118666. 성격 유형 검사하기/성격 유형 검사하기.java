import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scoreMap = new HashMap<>();
        char[] types = {'R','T','C','F','J','M','A','N'};
        for(char c : types){
            scoreMap.put(c, 0);
        }
        
        for(int i = 0; i < survey.length; i++){
            String type = survey[i];
            int choice = choices[i];
            char first = type.charAt(0);
            char second = type.charAt(1);
            
            if(choice < 4){
                scoreMap.put(first, scoreMap.get(first) + (4 - choice));
            } else if(choice > 4){
                scoreMap.put(second, scoreMap.get(second) + (choice - 4));
            }
        }
        
        StringBuilder result = new StringBuilder();
        result.append(scoreMap.get('R') >= scoreMap.get('T') ? 'R' : 'T');
        result.append(scoreMap.get('C') >= scoreMap.get('F') ? 'C' : 'F');
        result.append(scoreMap.get('J') >= scoreMap.get('M') ? 'J' : 'M');
        result.append(scoreMap.get('A') >= scoreMap.get('N') ? 'A' : 'N');
        
        return result.toString();
    }
}