import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> list = new HashMap<>();
        for(String p : participant){
            list.put(p, list.getOrDefault(p, 0) + 1);
        }

        for(String c : completion){
            list.put(c, list.get(c) - 1);
        }

        for(String li : list.keySet()){
            if(list.get(li) != 0){
                answer = li;
            }
        }
        return answer;
    }
}