package udemy.backtracking;

import java.util.Arrays;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//        boolean ans = isSorted(arr);
        boolean ans = isSorted(arr, 0);
        System.out.println(ans);
    }

    private static boolean isSorted(int[] arr) {
        if(arr.length == 1) return true;
        System.out.print(arr[0] + " ");
        int[] arr2 = Arrays.copyOfRange(arr, 1, arr.length);
        if(arr[0] < arr[1] && isSorted(arr2)) return true;
        return false;
    }
    private static boolean isSorted(int[] arr, int i) {
        if(arr.length - 1 == i) return true;
        if(arr[i] < arr[i+1] && isSorted(arr, i+1)) return true;
        return false;
    }
}
