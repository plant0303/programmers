import java.util.*;
class Solution {
  public int[] solution(int[] lottos, int[] win_nums) {
    int[] answer = new int[2];
    int cnt = 0;
    int zero = 0;

    Set<Integer> winSet = new HashSet<>();

    for (int i : win_nums) {
      winSet.add(i);
    }

    for (int i : lottos) {
      if (i == 0) {
        zero++;
      } else if(winSet.contains(i)) {
        cnt++;
      }
    }

    int high = 7 - Math.max(cnt + zero, 1);
    int low  = 7 - Math.max(cnt, 1);
      
      answer[0] = high;
    answer[1] = low;
      
    return answer;
  }

}