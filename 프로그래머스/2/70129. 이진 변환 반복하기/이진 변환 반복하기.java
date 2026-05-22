class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int remove0 = 0;

        String binary = s;

        while (!binary.equals("1")) {
        int after = 0;

          for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '1'){
              after++;
            } else{
              remove0++;
            }
          }
          binary = Integer.toBinaryString(after);
          cnt++;
        }
        
        return new int[] {cnt, remove0};
    }
}