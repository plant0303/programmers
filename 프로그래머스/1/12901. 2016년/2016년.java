class Solution {
    public String solution(int a, int b) {
    String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    int[] monthDay = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int day = 0;

    for(int i = 0; i < a - 1; i++){
      day += monthDay[i];
    }

    day = day + (b - 1);

    String result = "";
    result = week[day % 7];

        return result;
    }
}