package Graph.undirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSImplemention {
    static void createGraph(ArrayList<ArrayList<Integer>> adj){
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
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createGraph(adj);

        ArrayList<Integer> al = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (Integer it : adj.get(node)) {
                if(!visited[it]){
                    visited[it] = true;
                    q.add(it);
                }
            }
            al.add(node);
        }
        System.out.println(al);
    }
}
