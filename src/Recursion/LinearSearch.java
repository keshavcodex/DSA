package Recursion;

import java.util.ArrayList;

public class LinearSearch {
    static int searchNumber(int[] arr, int target, int index) {
        if (index == arr.length) return -1;
        if (arr[index] == target) return index;
        return searchNumber(arr, target, ++index);
    }

    static ArrayList searchAllIndex(int[] arr, int target, int index, ArrayList<Integer> al) {
        if (index == arr.length) return al;
        if (arr[index] == target) {
            al.add(index);
        }
        return searchAllIndex(arr, target, index + 1, al);
    }

    static ArrayList searchAllIndex2(int[] arr, int target, int index) {
        ArrayList<Integer> al = new ArrayList<>();
        if (index == arr.length) return al;
        if (arr[index] == target) {
            al.add(index);
        }
        ArrayList ansList = searchAllIndex2(arr, target, index + 1);
        al.addAll(ansList);
        return al;
    }

    public static void main(String[] args) {
        int[] arr = {12, 1, 23, 34, 2, 234, 23, 43, 4};
//        int ans = searchNumber(arr, 23, 0);
//        ArrayList<Integer> al = new ArrayList<>();
//        searchAllIndex(arr, 23, 0, al);
        System.out.println(searchAllIndex2(arr, 23, 0));
//        System.out.println("list of all indexes: " + al);
//        System.out.println("ans is at index: " + ans);
    }
}
