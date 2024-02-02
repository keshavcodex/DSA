package Recursion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class intro {
    static void checkSort(int[] arr, SortingFunc sortingFunc){
        int[] compSort = Arrays.copyOf(arr, arr.length);
        boolean flag = true;
        Arrays.sort(compSort);
        arr = sortingFunc.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != compSort[i]) {
                System.out.println("Array sorting didn't worked!");
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println("Sorting is fine!");
    }

//    static int[] bubbleSort(int []arr){
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] >= arr[j + 1]) {
//                    int temp = arr[j + 1];
//                    arr[j + 1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        return arr;
//    }

    public static void main(String[] args) {
        int arr[] = {1,23,23,2,34,2344,12,23,4,234,234,2344,34343};
        checkSort(arr, new BubbleSort());
    }
}

interface SortingFunc{
    int[] sort(int[] arr);
}
class BubbleSort implements SortingFunc {
    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
class insertionSort implements SortingFunc{
    @Override
    public int[] sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
        }
        return arr;
    }
}
