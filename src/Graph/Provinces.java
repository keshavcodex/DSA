package Graph;

import java.util.ArrayList;

public class Provinces  {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V){
    ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<Integer>());
        }
        // to change adjaceny matric to list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(adj.get(i).get(j) == 1 && i != j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                count++;
                dfs(i, adjLs, vis);
            }
        }
        return count;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, boolean[] vis) {
        vis[node] = true;
        for(int ele : adjLs.get(node)){
            if(!vis[ele]){
                dfs(ele, adjLs, vis);
            }
        }
    }
}
