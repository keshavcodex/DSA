package Graph;

import oops.access.A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Practice {
    static class DSU {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DSU(int n) {
            for (int i = 0; i < n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }

        int findUParent(int n) {
            if(parent.get(n) == n) return n;
            int ulp = findUParent(parent.get(n));
            parent.set(n, ulp);
            return ulp;
        }

        void unionByRank(int u, int v) {
            int ulpU = findUParent(u);
            int ulpV = findUParent(v);

            if(rank.get(ulpU) > rank.get(ulpV)) {
                parent.set(ulpV, ulpU);
            } else if(rank.get(ulpU) < rank.get(ulpV)) {
                parent.set(ulpU, ulpV);
            } else {
                parent.set(ulpV, ulpU);
                rank.set(ulpU, rank.get(ulpU) + 1);
            }
        }
    }
    public static void main(String[] args) {
        DSU dsu = new DSU(7);
        dsu.unionByRank(1, 2);
        dsu.unionByRank(2, 3);
        dsu.unionByRank(4, 5);
        dsu.unionByRank(6, 7);
        dsu.unionByRank(5, 6);

        System.out.println(dsu.findUParent(4));
    }
    static void filler(ArrayList<ArrayList<Integer>> adj){

//        edge 1 --- 2
        adj.get(1).add(2);
        adj.get(2).add(1);

//        edge 2 --- 3
        adj.get(2).add(3);
        adj.get(3).add(2);

//        edge 2 --- 4
        adj.get(2).add(4);
        adj.get(4).add(2);

//        edge 4 --- 5
        adj.get(4).add(5);
        adj.get(5).add(4);

//        edge 5 --- 8
        adj.get(5).add(8);
        adj.get(8).add(5);

//        edge 1 --- 6
        adj.get(1).add(6);
        adj.get(6).add(1);

//        edge 6 --- 7
        adj.get(6).add(7);
        adj.get(7).add(6);

//        edge 6 --- 9
        adj.get(6).add(9);
        adj.get(9).add(6);

//        edge 7 --- 8
        adj.get(7).add(8);
        adj.get(8).add(7);

    }

    static void display(ArrayList<ArrayList<Integer>> adj){
        for(ArrayList<Integer> ele: adj){
            System.out.println(ele);
        }
    }

    static void bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + ", ");
            for(int neighbour: adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i){
        visited[i] = true;
        System.out.print(i + ", ");
        for(int neighbour: adj.get(i)){
            if(!visited[neighbour]){
                dfs(adj, visited, neighbour);
            }
        }
    }
}
