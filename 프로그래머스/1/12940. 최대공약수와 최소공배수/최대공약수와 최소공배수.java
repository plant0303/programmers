import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, int m) {
    int[] answer = new int[2];
    List<Integer> gcd_n = gcdFunction(n);
    List<Integer> gcd_m = gcdFunction(m);
    int gcd = 1;

    //최대공약수 구하기
    for(int i = 0; i < gcd_n.size(); i++){
      for(int j = 0; j < gcd_m.size(); j++){
        if(gcd_m.contains(gcd_n.get(i))){
          gcd = gcd_n.get(i);
          answer[0] = gcd;
          System.out.println(gcd);
          break;
        }
      }
    }

    //최소공배수 구하기
    int lcm = n * m / gcd;
    answer[1] = lcm;

    return answer;
  }

  //약수 구하기
  public List<Integer> gcdFunction(int number) {
    List<Integer> gcdList = new ArrayList<Integer>();
  
    for (int i = 1; i <= number; i++) {
      if (number % i == 0) {
        gcdList.add(i);
      }
    }
    return gcdList;
  }
}