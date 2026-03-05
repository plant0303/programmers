class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == ' '){
                answer.append(' ');
                continue;
            }
            
            if(Character.isUpperCase(ch)){
                answer.append((char)((ch - 'A' + n) % 26 + 'A'));
                continue;
            }
            
            if(!Character.isUpperCase(ch)){
                answer.append((char)((ch - 'a' + n) % 26 + 'a'));
                continue;
            }
            
            answer.append((char)(ch + n));
            
            
        }
        return answer.toString();
    }
}