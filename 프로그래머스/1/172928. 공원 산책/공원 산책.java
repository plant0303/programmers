class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;

        // 지도 이차원 배열 생성
        char[][] parkMap = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                parkMap[i][j] = park[i].charAt(j);
                if (parkMap[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }

        // routes 지도 탐색
        for (int i = 0; i < routes.length; i++) {
            char direction = routes[i].charAt(0);
            int move = routes[i].charAt(2) - '0';
            int nx = x;
            int ny = y;
            boolean canMove = true;

            for(int j = 0; j < move; j++){
                if(direction == 'E') ny++;
                if(direction == 'W') ny--;
                if(direction == 'S') nx++;
                if(direction == 'N') nx--;
                
                if(ny >= parkMap[0].length || nx >= parkMap.length || nx < 0 || ny < 0 || parkMap[nx][ny] == 'X'){
                        canMove= false;
                        break;
                }
            }
            
            if(canMove){
                x = nx;
                y = ny;
            }

            System.out.println(x + " " + y);
        }

        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}