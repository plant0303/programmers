import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        Arrays.sort(dots, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
                return Integer.compare(a[0], b[0]);
        });
        
        answer = (dots[2][0] - dots[0][0]) * (dots[3][1] - dots[2][1]);
        
        return answer;
    }
}