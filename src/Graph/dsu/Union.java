package Graph.dsu;


public class Union {
    int find(int i, int[] parent) {
        if (i == parent[i]) {
            return i;
        }
        return find(parent[i], parent);
    }

    int pathCompression(int i, int[] parent) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }

    void union(int x, int y, int[] parent) {
        int xParent = find(x, parent);
        int yParent = find(y, parent);
        if (xParent != yParent) {
            parent[yParent]  = xParent;
        }
    }

    void rankBasedUnion(int x, int y, int[] parent, int[] rank) {
        int xParent = find(x, parent);
        int yParent = find(y, parent);
        if (xParent == yParent) return;

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
}
