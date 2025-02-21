package Graph.undirected;

import java.util.*;

public class CycleBFS {
    static boolean[] visited;
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
        visited = new boolean[adj.size()];
        System.out.println(isCyclic(adj) ? "This graph has a cycle." : "This graph don't have any cycle.");
    }

    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer,  Integer> parentMap = new HashMap<>();
        q.add(1);
        parentMap.put(1, -1);

        while(!q.isEmpty()){
            Integer node = q.poll();
            visited[node] = true;
            for(Integer child: adj.get(node)){
                int parent = parentMap.get(node);
                if(child == parent) continue;
                parentMap.put(child, node);
                if(visited[child]) {
                    return true;
                }
                q.add(child);
            }
        }
        return false;
    }

}