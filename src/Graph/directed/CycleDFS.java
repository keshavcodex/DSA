package Graph.directed;

import java.util.ArrayList;

public class CycleDFS {
    static void createGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < 10; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(1).add(6);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(2);
        adj.get(4).add(2);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(8);
        adj.get(6).add(1);
        adj.get(6).add(7);
        adj.get(6).add(9);
        adj.get(7).add(6);
        adj.get(7).add(8);
        adj.get(8).add(5);
        adj.get(8).add(7);
        adj.get(9).add(6);
    }

    static void directeGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < 3; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(1);
    }

    static boolean[] visited;
    static boolean[] inRecursion;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//        createGraph(adj);
        directeGraph(adj);
        visited = new boolean[adj.size()];
        inRecursion = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Starting node " + i + (isCycle(adj, inRecursion, i) ? " makes a cycle." : " does not make a cycle."));
        }
    }

    static boolean isCycle(ArrayList<ArrayList<Integer>> adj, boolean[] inRecursion, int node) {
        visited[node] = true;
        inRecursion[node] = true;
        for (Integer neighbour : adj.get(node)) {
            if (!visited[neighbour] && isCycle(adj, inRecursion, neighbour)) {
                return true;
            } else if (inRecursion[neighbour]) return true;
        }
        inRecursion[node] = false;
        return false;
    }
}
