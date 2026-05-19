import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> MaxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> MinQueue = new PriorityQueue<>();
        
        for(int i = 0; i < operations.length; i++){
            String[] split = operations[i].split(" ");
            
            if(split[0].equals("I")){
                String value = split[1];
                MaxQueue.add(Integer.parseInt(value));
                MinQueue.add(Integer.parseInt(value));
            }
            
            if(operations[i].equals("D 1") && !MaxQueue.isEmpty()){
                int max = MaxQueue.poll();
                MaxQueue.remove(max);
                MinQueue.remove(max);
            }
            
            if(operations[i].equals("D -1") && !MinQueue.isEmpty()){
                int min = MinQueue.poll();
                MaxQueue.remove(min);
                MinQueue.remove(min);
            }
        }
        
        if(MaxQueue.isEmpty() || MinQueue.isEmpty()){
            return new int[] {0, 0};
        }
                             
        return new int[] {MaxQueue.poll(), MinQueue.poll()};
    }
}