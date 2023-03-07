package Graph;

import java.util.ArrayList;

public class DFS {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];
        ArrayList<Integer> ls = new ArrayList<>();
        return dfs(0, vis, adj, ls);
    }

    public ArrayList<Integer> dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        vis[node] = true;
        ls.add(node);
        for(Integer ele: adj.get(node)){
            if(!vis[ele]){
                dfs(ele, vis, adj, ls);
            }
        }
        return ls;
    }

}
