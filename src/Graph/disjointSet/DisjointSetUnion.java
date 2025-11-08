package Graph.disjointSet;

import java.util.*;
import java.util.List;

public class DisjointSetUnion {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSetUnion(int n) {
        for(int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }
    int findUParent(int n) {
        if(parent.get(n) == n) return n;
        int ulp = findUParent(parent.get(n));
        parent.set(n, ulp);
        return parent.get(n);
    }
    void unionByRank(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rank_u = rank.get(ulp_u);
            rank.set(ulp_u, rank_u + 1);
        }
    }

    public static void main(String[] args) {
        DisjointSetUnion ds = new DisjointSetUnion(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
    }
}
