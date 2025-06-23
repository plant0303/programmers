class Solution {
    public int solution(String s) {
        
    String[] words = {"zero", "one", "two", "three", "four",
                          "five", "six", "seven", "eight", "nine"};
    
    for(int i = 0; i < words.length; i++){
        s = s.replaceAll(words[i], String.valueOf(i));
    }
    int answer = 0;
    answer = Integer.parseInt(s);
    return answer;
    }
}