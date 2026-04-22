class Solution {
    public int solution(int num1, int num2) {
        double num1d = (double)num1;
        double num2d = (double)num2;
        double result = (num1d / num2d) * 1000;
        int answer = (int)result;
        return answer;
    }
}