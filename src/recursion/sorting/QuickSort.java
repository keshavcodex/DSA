package recursion.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, -1, 5475, 46, 78, 464, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        // now my pivot is at correct index, please sort two halves now
        sort(nums, low, e);
        sort(nums, s, high);
    }
}
