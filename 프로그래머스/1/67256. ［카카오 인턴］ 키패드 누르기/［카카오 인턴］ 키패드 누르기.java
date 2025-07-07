class Solution {
    public String solution(int[] numbers, String hand) {
    String answer = "";
    int[][] keypad = new int[12][2];
    int row = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        keypad[row][0] = i;
        keypad[row][1] = j;
        row++;
      }
    }

    int[] left = { 3, 0 };
    int[] right = { 3, 2 };

    for (int i : numbers) {
      int index = (i == 0) ? 10 : i - 1;
      int[] target = keypad[index];

      if (i == 1 || i == 4 || i == 7) {
        answer += "L";
        left = target;
      } else if (i == 3 || i == 6 || i == 9) {
        answer += "R";
        right = target;
      } else {
        int leftDist = Math.abs(left[0] - target[0]) + Math.abs(left[1] - target[1]);
        int rightDist = Math.abs(right[0] - target[0]) + Math.abs(right[1] - target[1]);

        if (leftDist < rightDist) {
          answer += "L";
          left = target;
        } else if (leftDist > rightDist) {
          answer += "R";
          right = target;
        } else {
          if (hand.equals("right")) {
            answer += "R";
            right = target;
          } else {
            answer += "L";
            left = target;
          }
        }
      }
    }

    return answer;
    }
}