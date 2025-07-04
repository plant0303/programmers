class Solution {
    public int solution(int[][] sizes) {
    int j = 0;
    for(int i = 0; i < sizes.length; i++){
      int temp = 0;
      
      if(sizes[i][j] < sizes[i][j+1]){
        temp = sizes[i][j];
        sizes[i][j] = sizes[i][j+1];
        sizes[i][j+1] = temp;
      }
    }

    int maxX = 0;
    int maxY = 0;
    for(int i = 0; i < sizes.length; i++){
      maxX = Math.max(maxX, sizes[i][j]);
      maxY = Math.max(maxY, sizes[i][j+1]); 
    }
    return maxX * maxY;
    }
}