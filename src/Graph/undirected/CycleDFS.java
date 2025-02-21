package Graph.undirected;

import java.util.ArrayList;

//import static Graph.undirected.DFSImplementation.createGraph;

public class CycleDFS {
    static boolean[] visited;

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
//        adj.get(6).add(9);
        adj.get(7).add(6);
        adj.get(7).add(8);
        adj.get(8).add(5);
        adj.get(8).add(7);
//        adj.get(9).add(6);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createGraph(adj);
        visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i] && cycleDetection(adj, i, -1)) {
                System.out.println("This graph has a cycle.");
            } else if (!cycleDetection(adj, i, -1)) {
                System.out.printf("Node %s doesn't created a cycle\n", i);
            }
        }
    }

    static boolean cycleDetection(ArrayList<ArrayList<Integer>> adj, int node, int parent) {
        visited[node] = true;
        for (Integer neighbour : adj.get(node)) {
            if (neighbour == parent) continue;
            if (visited[neighbour]) return true;
            if (cycleDetection(adj, neighbour, node)) {
                return true;
            }
        }
        return false;
    }
}
// 1, 0, 2, 5, 6, 3, 4, 8, 7