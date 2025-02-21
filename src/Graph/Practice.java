package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Practice {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited;
    static ArrayList<Integer> ans;

    static void createGraph() {
        for (int i = 0; i < 9; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
//        adj.get(3).add(6);

        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(6);
        adj.get(6).add(5);

        adj.get(7).add(8);
        adj.get(8).add(7);
    }

    static int provincesCount = 0;

    static void dfs(Integer node) {
        visited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour])
                dfs(neighbour);
        }
    }

    static void bfs(Integer node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            node = q.poll();
            visited[node] = true;
            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }

    }

    public static void main(String[] args) {
        createGraph();
        visited = new boolean[adj.size()];

        for (int i = 1; i < adj.size(); i++) {
            if (!visited[i]) {
//                dfs(i);
                bfs(i);
                provincesCount++;
            }
        }
        System.out.println(provincesCount);
    }
}
