package Graph.undirected;

import java.util.ArrayList;

public class Intro {
    public static void main(String[] args) {

        int n = 3, m = 3;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            al.add(new ArrayList<>());
        }
        al.get(1).add(2);
        al.get(1).add(3);
        al.get(2).add(1);
        al.get(2).add(4);
        al.get(2).add(5);
        al.get(3).add(1);
        al.get(3).add(4);
        al.get(4).add(2);
        al.get(4).add(3);
        al.get(4).add(5);
        al.get(5).add(2);
        al.get(5).add(4);

        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
    }
}
