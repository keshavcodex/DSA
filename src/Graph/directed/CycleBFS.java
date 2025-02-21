package Graph.directed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static Graph.directed.TopologicalSortBFS.sort;

public class CycleBFS {
    static void createGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i <= 6; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createGraph(adj);
        detectCycle(adj);
    }
    private static void detectCycle(ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        int n = adj.size();
        int count = 0;
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for(int neighbour: adj.get(i)){
                indegree[neighbour]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int node = q.poll();
            for(int neighbour: adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
            count++;
        }

        System.out.println(count == n? "No cycle found." : "Cycle present in graph.");
    }
}
