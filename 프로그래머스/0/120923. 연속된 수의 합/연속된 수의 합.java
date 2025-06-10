class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int key = total / num;
        int first = key - ((num - 1) / 2);
        
        for(int i = 0, j = first; i < num; i++, j++){
            answer[i] = j;
        }
 
        return answer;
    }
}