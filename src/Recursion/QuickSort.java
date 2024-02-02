package Recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {88, 23, 42, 23423, 345, 423, 4, 137645, 7, 74, 86, 7967, 744};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr) {
        System.out.println("Quick Sort");
        quickSort(arr, 0, arr.length - 1);
    }
    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int s = low, e = high;
        int mid = (e - s) / 2 + s;
        int pivot = arr[mid];

        while (s <= e){
            while(arr[s] < pivot) s++;
            while(arr[e] > pivot) e--;
            if(s <= e){
                swap(arr, s, e);
                s++;
                e--;
            }
        }
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }

    static void swap(int[] arr, int n, int m) {
        int temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }
}
