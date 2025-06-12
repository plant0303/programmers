import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        String numStr = "";
        int scoreIndex = -1;
        
        for(int i = 0; i < dartResult.length(); i++){
            char ch = dartResult.charAt(i);
            
            if(Character.isDigit(ch)){
                numStr += ch;    
            } else if(ch == 'S' || ch == 'D' || ch == 'T'){
                scoreIndex++;
                int num = Integer.parseInt(numStr);
                numStr = "";
                if(ch == 'S'){
                    num = (int)Math.pow(num, 1);
                } else if(ch == 'D'){
                    num = (int)Math.pow(num, 2);
                } else if(ch == 'T'){
                    num = (int)Math.pow(num, 3);
                }
                
                score[scoreIndex] = num;
            } else if(ch == '*'){
                score[scoreIndex] *= 2;
                if (scoreIndex > 0) {
                    score[scoreIndex - 1] *= 2;
                }
            } else if(ch == '#'){
                score[scoreIndex] *= -1;
            }
        }
        
        for (int s : score) answer += s;
        return answer;
    }
}