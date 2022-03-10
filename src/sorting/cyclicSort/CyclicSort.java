package sorting.cyclicSort;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 4, 3,6,9,8,7};
        System.out.println(Arrays.toString(arr));
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cyclicSort(int[] arr){
        int i = 0;
        while (i < arr.length) {
            if(arr[i] - 1 != i){
                swap(arr, arr[i] - 1, i);
            }else i++;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
