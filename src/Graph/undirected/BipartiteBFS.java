package Graph.undirected;

import java.util.*;

public class BipartiteBFS {
    static boolean bipartite(ArrayList<ArrayList<Integer>> adj, int node,int[] color, int colorCode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = colorCode;

        while(!q.isEmpty()){
            node = q.poll();
            for(int neighbour: adj.get(node)){
                if(color[neighbour] == color[node]) return false;
                else if(color[neighbour] == -1){
                    q.add(neighbour);
                    color[neighbour] = 1 - color[node];
                }
            }
        }
        return true;
    }
}
