import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {

    boolean[] visited = new boolean[n + 1];

    // 노드 그리기
    List<Integer>[] graph = new ArrayList[n + 1];
    ;
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] e : edge) {
      int parent = e[0];
      int child = e[1];

      graph[parent].add(child);
      graph[child].add(parent);
    }

    int[] distance = bfs(1, graph, visited, n);

    // 최대값 찾기
    int max = Arrays.stream(distance).max().getAsInt();

    int cnt = 0;
    for (int d : distance) {
      if (d == max) {
        cnt++;
      }
    }
        return cnt;
    }
    
      static int[] bfs(int start, List<Integer>[] graph, boolean[] visited, int n) {
    // bfs 탐색 큐
    Queue<Integer> queue = new LinkedList<Integer>();
    int[] distance = new int[n + 1];

    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int nodeIndex = queue.poll();

      for (int i = 0; i < graph[nodeIndex].size(); i++) {
        int temp = graph[nodeIndex].get(i);

        if (!visited[temp]) {

          queue.offer(temp);
          visited[temp] = true;
          distance[temp] = distance[nodeIndex] + 1;
        }
      }
    }

    return distance;
  }
}