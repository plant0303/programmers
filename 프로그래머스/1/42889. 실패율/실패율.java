import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int stage : stages) {
            if (stage > N)
                continue;
            map.put(stage, map.getOrDefault(stage, 0) + 1);
        }

        for (int i = 1; i <= N; i++) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
        }

        // 실패율 계산
        HashMap<Integer, Double> fail = new HashMap<>();
        int temp = stages.length;
        for (int i = 1; i <= N; i++) {
            if(temp == 0){
                fail.put(i, 0.0);
                continue;
            }
            fail.put(i, (double) map.get(i) / temp);
            temp = temp - map.get(i);
        }

        // 내림차순 정렬
        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(fail.entrySet());
        entryList.sort((o1, o2) -> {
            int res = o2.getValue().compareTo(o1.getValue());
            
            if(res == 0){
                return o1.getKey().compareTo(o2.getKey());
            }
            return res;
        } );


        answer = entryList.stream().mapToInt(Map.Entry::getKey).toArray();

        return answer;
    }
}