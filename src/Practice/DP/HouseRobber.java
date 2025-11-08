package Practice.DP;

import java.util.Arrays;

// Maximum sum of non-adjacent elements
public class HouseRobber {
    static Integer[] dp;

    public static void main(String[] args) {
        int[] arr = {4, 8, 7, 15, 10};  //ans = 23

        dp = new Integer[arr.length + 1];
        int ans = maximumSum(0, arr);
        System.out.println("maximumSum: " + ans);
        System.out.println("Tab max sum: " + maximumSum(arr));
    }

    private static int maximumSum(int i, int[] arr) {
        if (i >= arr.length) return 0;

        if (dp[i] != null) return dp[i];

        int picked = maximumSum(i + 2, arr) + arr[i];
        int notPicked = maximumSum(i + 1, arr);

        return dp[i] = Math.max(picked, notPicked);
    }
    private static int maximumSum(int[] arr) {
        int n = arr.length;
        int prev = arr[0];
        int prev2 = arr[1];
        for (int i = 1; i < n; i++) {
            int take = arr[i];
            if(i > 1) take += prev2;
            int notTake = prev;
            prev2 = prev;
            prev = Math.max(take, notTake);
        }
//        System.out.println(Arrays.toString(dp));
        return prev;
    }
}
