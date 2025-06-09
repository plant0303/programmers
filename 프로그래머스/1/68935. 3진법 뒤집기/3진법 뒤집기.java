import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        // 10진법 -> 3진법
        while(n > 0){
            sb.insert(sb.length(), n % 3);
            n = n / 3;
        }
        
        // 3진법 -> 10진법
        int powr = 0;
        int decimal = 0;
        for(int i = sb.length() - 1 ; i >= 0; i--){
            int digit = sb.charAt(i) - '0';
            decimal += digit * Math.pow(3, powr);
            powr++;
        }
        
        answer = decimal;
        return answer;
    }
}