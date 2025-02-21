package Graph.directed;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {
    static boolean[] visited;

    static void createGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i <= 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(3);
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(1).add(4);
        adj.get(5).add(1);
        adj.get(5).add(4);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createGraph(adj);
        int n = adj.size();
        visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[n-1-i]) {
                sort(adj, st,  n-1-i);
            }
        }
        for (int i = 0; i < n; i++) {
            ans.add(st.pop());
        }
        System.out.println(ans);
    }

    static void sort(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int node) {
        visited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                sort(adj, st, neighbour);
            }
        }
        st.add(node);
    }
}
