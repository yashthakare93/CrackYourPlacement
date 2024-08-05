package Day18;

import java.util.*;

class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> dfs) {
        vis[node] = true;
        dfs.add(node);

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, adj, vis, dfs);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[]
        vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, dfs);
            }
        }

        return dfs;
    }
}