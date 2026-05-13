class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        int N = arr.length;
        int sr = 0;
        int sc = 0;
        Quadtree(sr, sc, N, arr);
        
        return answer;
    }
    
    public void Quadtree(int sr, int sc, int N, int[][] arr){
        int first = arr[sr][sc];
        
        if(divideArr(first, arr, N, sr, sc)){
            answer[first]++;
            return;
        }
        
        int new_N = N / 2;
        
        // 상 왼
        Quadtree(sr, sc, new_N, arr);
        // 상 우
        Quadtree(sr, sc + new_N, new_N, arr);
        // 하 왼
        Quadtree(sr + new_N, sc, new_N, arr);
        // 하 우
        Quadtree(sr + new_N, sc + new_N, new_N, arr);
        
    }
    
    public boolean divideArr(int first, int[][] arr, int N, int sr, int sc){
        for(int i = sr; i < sr + N; i ++){
            for(int j = sc; j < sc + N; j++){
                if(arr[i][j] != first) return false;
            }
        }
        return true;
    }
}