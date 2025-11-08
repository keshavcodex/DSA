package Practice.Recursion;

import java.util.ArrayList;

public class Sequence {
    static ArrayList<Integer> list = new ArrayList<>();

    static void seq(int[] arr, int i) {
        if(i == arr.length){
            System.out.println(list);
            return;
        }
        list.add(arr[i]);
        seq(arr, i + 1);
        list.removeLast();

        seq(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double s = System.currentTimeMillis();
        seq(arr, 0);
        double e = System.currentTimeMillis();
        System.out.println(e - s);
    }
}
