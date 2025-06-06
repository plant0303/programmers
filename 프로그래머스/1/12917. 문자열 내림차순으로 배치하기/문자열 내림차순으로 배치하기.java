class Solution {
    public String solution(String s) {
        String answer = "";
        int[] arr = new int[s.length()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = ((int)s.charAt(i));
        }
        
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // key보다 작은 값들을 뒤로 밀기
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        
        for(int i = 0; i < arr.length; i++){
            answer += (char)(arr[i]);
        }
        return answer;
    }
}