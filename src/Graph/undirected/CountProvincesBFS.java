package Graph.undirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountProvincesBFS {
    static void createGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i <= 7; i++) {
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

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createGraph(adj);
        boolean[] visited = new boolean[adj.size()];
        int count = 0;
        for(int i = 1; i < adj.size(); i++){
            if(!visited[i]){
                BFS(adj, visited, i);
                count++;
            }
        }
        System.out.println("count: " + count);
    }
    public static void BFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            node = q.poll();
            System.out.print(node + ", ");
            for(int neighbour: adj.get(node)) {
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        System.out.println();
    }
}
