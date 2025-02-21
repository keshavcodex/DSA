package Graph.dsu;

import java.util.ArrayList;

public class CycleDetectUsingDSU {

    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int neighbour : adj.get(i)) {
                if (neighbour < i) {
                    int parent_Ne = find(neighbour, parent);
                    int parent_I = find(i, parent);
                    if (parent_Ne == parent_I) return true;
                    union(neighbour, i, parent);
                }
            }
        }
        return false;
    }

    public int find(int i, int[] parent) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i], parent);
    }

    public void union(int x, int y, int[] parent) {
        int xParent = find(x, parent);
        int yParent = find(y, parent);

        parent[yParent] = xParent;
    }
}