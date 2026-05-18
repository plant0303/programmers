import java.util.*;

class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<Integer>[] forwardGraph = new ArrayList[n + 1];
        List<Integer>[] backwardGraph = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++) {
            forwardGraph[i] = new ArrayList<>();
            backwardGraph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < results.length; i++){
            forwardGraph[results[i][0]].add(results[i][1]);
            backwardGraph[results[i][1]].add(results[i][0]);
        }
        
        for(int i = 1; i <= n; i++){
            visited = new boolean[n + 1];
            int winCnt = dfs(i, forwardGraph) - 1;
            
            visited = new boolean[n + 1];
            int loseCnt = dfs(i, backwardGraph) - 1;
            
            if(winCnt + loseCnt == n - 1){
                answer++;
            }
        }
        
        return answer;
    }
    
    // dfs 탐색하면서 총 노드의 개수 리턴
    public int dfs(int nodeIndex, List<Integer>[] graph){
        visited[nodeIndex] = true;
        int count = 1;
        
        for(int next : graph[nodeIndex]){
            if(!visited[next]){
                count += dfs(next, graph);
            }     
        }
        return count;
    }
}