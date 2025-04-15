import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, int m) {
    int[] answer = new int[2];

    int gcd = gcdFunction(n, m);
    answer[0] = gcd;
    
    //최소공배수 구하기
    int lcm = n * m / gcd;
    answer[1] = lcm;

    return answer;
  }

  //최대공약수 구하기
  public int gcdFunction(int a, int b) {
    while(b != 0){
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}