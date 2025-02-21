package Graph.undirected;

import java.util.ArrayList;
public class countProvincesDFS {
    static boolean[] visited;
    static void createGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i <= 8; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(2).add(6);
        adj.get(5).add(2);
        adj.get(6).add(2);

        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(3);
        adj.get(7).add(3);

    }

    static int countProvince(ArrayList<ArrayList<Integer>> adj) {
        int count = 0;
        for (int i = 1; i < adj.size(); i++) {
            if (!visited[i]) {
                dfs(adj, i);
                count++;
            }
        }
        return count;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int node) {
        visited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour])
                dfs(adj, neighbour);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createGraph(adj);
        visited = new boolean[adj.size() + 1];
        System.out.println("count is: " + countProvince(adj));
    }
}