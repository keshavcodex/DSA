package recursion.arrayProblems;

import java.util.Scanner;

public class RoatatedBS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {5, 7, 8, 9, 1, 2, 3};
//        while (true) {
//            int target = sc.nextInt();
            int target = 9;
            int ans = search(arr, target, 0, arr.length - 1);
            System.out.println(ans);
//        }
    }

    static int search(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (arr[s] <= arr[m]) {
            if (target >= arr[s] && target <= arr[m]) {
                return search(arr, target, s, m - 1);
            } else {
                return search(arr, target, m + 1,e);
            }
        }
        if (target >= arr[m] && target <= arr[e]) {
            return search(arr, target, m + 1, e);
        }
        return search(arr, target, s, m - 1);
    }
}
