package recursion.sorting;

import java.util.Arrays;

public class MergeSortOptimised {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 0};
        mergeSortInPlace(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSortInPlace(int[] arr) {
        mergeSortInPlace(arr, 0, arr.length);
    }

    static void mergeSortInPlace(int[] arr, int s, int e) {
        if ((e-s) == 1) {
            return;
        }
        int mid = (s + e) / 2;
        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);
        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];
        int i = s;
        int j = m;
        int k = 0;
        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i++];
            } else {
                mix[k] = arr[j++];
            }
            k++;
        }
        while (i < m) {
            mix[k++] = arr[i++];
        }
        while (j < e) {
            mix[k++] = arr[j++];
        }
        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }
}
