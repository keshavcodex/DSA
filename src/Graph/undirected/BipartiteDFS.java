package Graph.undirected;

import java.util.ArrayList;

public class BipartiteDFS {
    static boolean bipartite(ArrayList<ArrayList<Integer>> adj, int node,int[] color, int colorCode) {
        color[node] = colorCode;

        for(int neighbour: adj.get(node)){
            if(color[neighbour] == color[node]) return false;
            if(color[neighbour] == -1 && !bipartite(adj, neighbour, color, 1 - colorCode)){
                return false;
            }
        }
        return true;
    }
}
