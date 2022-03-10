package recursion.patterns;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        triangle(4, 0);
        int[] arr = {4, 3, 28, 11};
//        bubble(arr, arr.length - 1, 0);
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void triangle(int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            System.out.print(" * ");
            triangle(r, c + 1);
        } else {
            System.out.println();
            triangle(r - 1, 0);
        }
    }

    static void bubble(int[] arr, int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[c + 1]) {
                swap(arr, c, c + 1);
            }
                bubble(arr, r, c + 1);
        } else {
                bubble(arr, r - 1, 0);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void selectionSort(int[] arr) {
        selectionSort(arr, arr.length, 0, 0);
    }

    static void selectionSort(int[] arr, int r, int c, int max) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[max]) {
                selectionSort(arr, r, c + 1, c);
            } else {
                selectionSort(arr, r, c + 1, max);
            }
        } else {
            swap(arr, max, r -1);
            selectionSort(arr, r - 1, 0, 0);
        }

    }

}
