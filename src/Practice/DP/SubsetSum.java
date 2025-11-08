package Practice.DP;

import helper.Timer;

import java.util.ArrayList;

public class SubsetSum {
    static ArrayList<Integer> al = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1, 12, 3, 4, 23, 233, 54};
        int target = 70;
        Boolean[][] dp = new Boolean[arr.length][target + 1];

        Timer.start();
        System.out.println(target + (subsetSumExistRecursive(0, arr, target, dp) ? " sum exists" : " sum doesn't exist"));
        System.out.println("tabulation: " + target + (subsetSumExistTabulation(arr, target) ? " sum exists" : " sum doesn't exist"));
        Timer.end();
    }

    private static boolean subsetSumExistTabulation(int[] arr, int k) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notTaken = dp[i - 1][target];
                boolean taken = (arr[i] <= target) ? dp[i - 1][target - arr[i]] : false;

                dp[i][target] = notTaken || taken;
            }
        }
        return dp[n - 1][k];
    }

    private static boolean subsetSumExistRecursive(int i, int[] arr, int target, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }
        if (i == arr.length || target < 0) return false;

        if (dp[i][target] != null) return dp[i][target];

        boolean taken = subsetSumExistRecursive(i + 1, arr, target - arr[i], dp);
        boolean notTaken = subsetSumExistRecursive(i + 1, arr, target, dp);

        return dp[i][target] = notTaken || taken;
    }
}
