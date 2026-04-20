import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        String[] list = Arrays.stream(report).distinct().toArray(String[]::new);
        
        Map<String, Integer> reportCount = new HashMap<>();
        for(String r : list){
            String[] user = r.split(" ");
            String reported = user[1];
            reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);
        }
        
        Set<String> block = new HashSet<>();
        for(String r : reportCount.keySet()){
            if(reportCount.get(r) >= k){
                block.add(r);
            }
        }
        
        for(String r : list){
            String[] user = r.split(" ");
            String reporter = user[0];
            String reported = user[1];
            
            if(block.contains(reported)){
                int index = Arrays.asList(id_list).indexOf(reporter);
                answer[index]++;
            }
        }
        
        return answer;
    }
}