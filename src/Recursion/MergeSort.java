package Recursion;

import java.util.*;

public class MergeSort {
    static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    static void mergeSort(int[] arr, int s, int e) {
        if (e < 1 || e ==  s + 1) return;
        int mid = (e - s) / 2 + s;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid, e);
        mergeInPlace(arr, s, mid, e);
    }

    static void mergeInPlace(int[] arr, int s, int mid, int e) {
        int[] nums = new int[e - s];
        int i = s, j = mid, k = 0;
        while (i < mid && j < e) {
            if (arr[i] < arr[j]) {
                nums[k++] = arr[i++];
            } else nums[k++] = arr[j++];
        }
        while (i < mid) {
            nums[k++] = arr[i++];
        }
        while (j < e) {
            nums[k++] = arr[j++];
        }
        for (int l = 0; l < nums.length; l++) {
            arr[l + s] = nums[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {88, 23, 42, 23423, 345, 423, 4, 4, 137645, 7, 74, 86, 7967, 744};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
