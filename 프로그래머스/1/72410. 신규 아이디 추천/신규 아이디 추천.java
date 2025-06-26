class Solution {
    public String solution(String new_id) {
    // 1단계: 대문자 -> 소문자
    new_id = new_id.toLowerCase();

    // 2단계: -, _, . 를 제외한 특수문자 제거
    // !@#$%^&*()=+[]\|/? 제거해야... 
    new_id = new_id.replaceAll("[^a-zA-Z0-9\\-_.]", "");

    // 3단계: 마침표 연속되면 하나로 치환
    new_id = new_id.replaceAll("[.]{2,}", ".");

    // 4단계: 마침표가 처음이나 끝에 있으면 제거
    new_id = new_id.replaceAll("^[.]+|[.]+$", "");

    // 5단계: 빈 문자열일 경우 a 대입
    if(new_id.length() == 0){
      new_id = "a";
    } 

    // 6단계: 문자열 15개까지 허용
    if(new_id.length() >= 16){
      new_id = new_id.substring(0, 15);
        new_id = new_id.replaceAll("^[.]+|[.]+$", "");
    }

    // 7단계: 길이가 2자 이하라면 마지막 문자를 3이 될때까지 반복
    if(new_id.length() <= 2){
      while(new_id.length() < 3){
        new_id = new_id + new_id.charAt(new_id.length() - 1);
      }
    }
   

    return new_id;
    }
}