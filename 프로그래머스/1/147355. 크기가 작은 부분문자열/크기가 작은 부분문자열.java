class Solution {
    public int solution(String t, String p) {
        Long[] arr = new Long[t.length() - (p.length() - 1)];

        for(int i = 0; i < arr.length; i++){
            int num = i + p.length();
            arr[i] = Long.parseLong(t.substring(i, num));
        }

        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
          if(arr[i] <= Long.parseLong(p)){
            cnt++;
          }
        }
        return cnt;
    }
}