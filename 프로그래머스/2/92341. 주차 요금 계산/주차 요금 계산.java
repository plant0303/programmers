import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parking = new HashMap<String, Integer>();
        Map<String, Integer> totalTime = new HashMap<String, Integer>();

        // 누적 주차 시간 계산
        for (int i = 0; i < records.length; i++) {
            String[] parts = records[i].split(" ");
            int time = convertToMin(parts[0]);
            String status = parts[2];
            String carNum = parts[1];

            if (status.equals("IN")) {
                parking.put(carNum, time);
            } else {
                // out일때
                int inTime = parking.remove(carNum);
                int parkTime = time - inTime;
                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + parkTime);
            } 
        }

        // 입차기록이 있는데 출차기록이 없는 경우 23:59 로 계산
        for(String park : parking.keySet()){
            int inTime = parking.get(park);
            int time = convertToMin("23:59") - inTime;
            totalTime.put(park, totalTime.getOrDefault(park, 0) + time);
        }
        
        // 번호판 올림차순 정리
        List<String> carNumber = new ArrayList<String>(totalTime.keySet());
        Collections.sort(carNumber);

        // 주차 요금 계산
        int[] answer = new int[carNumber.size()];
        int cnt = 0;
        for(String carNum : carNumber){
            int time = totalTime.get(carNum);
            if(time < fees[0]){
                // 누적 주차 시간이 180분 이하인 경우
                answer[cnt] = fees[1];
                cnt++;
            } else{
                int rest = time - fees[0];
                if(rest % fees[2] != 0){
                    // 단위시간 안나누어 떨어져서 반올림 하는 경우
                    answer[cnt] = (fees[1] + (rest / fees[2]) * fees[3]) + fees[3];
                } else{
                    answer[cnt] = (fees[1] + (rest / fees[2]) * fees[3]);
                }
                cnt++;
            }
        }
        return answer;
    }
        // 시간 변환 함수
    public int convertToMin(String min) {
        String[] time = min.split(":");
        int minutes = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        return minutes;
    }
}