package Math;

import java.util.*;

public class Fun {
    static int count = 0;
    static void subArraySumBrute(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == target) {
                    printSubArray(arr, i, j);
                }
            }
        }
    }

    static void slidingWindow(int[] arr, int target) {
        int sum = 0, startIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > target) {
                while (sum > target && startIndex < i) {
                    sum -= arr[startIndex];
                    startIndex++;
                }
                if (sum == target) {
                    printSubArray(arr, startIndex, i);
                }
            } else if (sum == target) {
                printSubArray(arr, startIndex, i);
            }
        }
    }

    static void printSubArray(int[] arr, int s, int e) {
        count++;
        for (int i = s; i <= e; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, -3, 3, 1, 6, -2, 4, 2, 1, 1};
        int target = 4;
        subArraySumBrute(arr, target);
        System.out.println("count: " + count);
        count= 0;
        System.out.println("____________________");
        slidingWindow(arr, target);
        System.out.println("count: " + count);
    }
}
