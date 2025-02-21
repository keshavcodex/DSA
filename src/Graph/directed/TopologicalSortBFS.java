package Graph.directed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {
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
    static int[] indegree;
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createGraph(adj);

        sort(adj);
    }
    public static void sort(ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        int n = adj.size();
        indegree = new int[n];
        System.out.println("[0, 1, 2, 3, 4, 5]");
        for (int i = 0; i < n; i++) {
            for(int neighbour: adj.get(i)){
                indegree[neighbour]++;
                System.out.println(Arrays.toString(indegree));
            }
        }
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + ", ");
            for(int neighbour: adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
    }
}
