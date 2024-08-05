package Day18;
import java.util.*;

class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            bfs.add(u);

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }

        return bfs;
    }
}