class Solution {
    public int solution(String s) {
    int answer = 0;
    String[] arr = s.split("");
    int same = 0;
    int diff = 0;
    String x = arr[0];
    for(int i = 0; i < arr.length; i++){

      if(x.equals(arr[i])){
        same++;
      } else{
        diff++;
      }

      if(same == diff){
        answer++;
        same = 0;
        diff = 0;
        if(i + 1 < arr.length){
          x = arr[i+1];
        }
      } else if(same != diff && arr.length <= i + 1){
        answer++;
      }

    }
    return answer;
    }
}