package Graph.undirected;

import java.util.ArrayList;

public class DFSImplementation {
    static void createGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i <= 8; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(2).add(6);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(3);
        adj.get(4).add(8);
        adj.get(5).add(2);
        adj.get(6).add(2);
        adj.get(7).add(3);
        adj.get(7).add(8);
        adj.get(8).add(4);
        adj.get(8).add(7);
    }

    static void displayDFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, ArrayList<Integer> al) {
        visited[node] = true;
        al.add(node);
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour])
                displayDFS(adj, visited, neighbour, al);
        }
    }
    static void displayDFS2(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node){
        visited[node] = true;
        System.out.print(node + ", ");
        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]) displayDFS2(adj, visited, neighbour);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        createGraph(adj);
        boolean[] visited = new boolean[adj.size() + 1];
        displayDFS(adj, visited, 1, al);
        System.out.println(al);

    }
}
