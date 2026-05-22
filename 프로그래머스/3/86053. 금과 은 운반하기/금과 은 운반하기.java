class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = 0;
        long left = 0;
        long right = 400000000000000L;
        long mid = right / 2;

        while (left <= right) {
          mid = (left + right) / 2;
          long gold = 0;
          long silver = 0;
          long total = 0;
            
          for (int i = 0; i < s.length; i++) {
            long move = (mid + t[i]) / (2 * t[i]);
            long weight = move * w[i];
            gold += Math.min(g[i], weight);
            silver += Math.min(s[i], weight);
            total += Math.min(g[i] + s[i], weight);
          }
          if (gold >= a && silver >= b && total >= (long) a + b) {
            answer = mid;
            right = mid - 1;
          } else{
            left = mid + 1;
          }
        }
        return answer;
    }
}