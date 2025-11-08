package dynamicProgramming;

public class PartitionEqualSubset {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 4, 5, 4, 20};

        boolean ans = canPartition(arr);
        System.out.println("partition exist?: " + ans);
    }

    private static boolean canPartition(int[] arr) {
        int totalSum = 0;
        for (int ele: arr) {
            totalSum += ele;
        }
        if((totalSum & 1) == 1) return false;

        return subsetSumExistTabulation(arr, totalSum/2);
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
                boolean taken = arr[i] <= target && dp[i - 1][target - arr[i]];

                dp[i][target] = notTaken || taken;
            }
        }
        return dp[n - 1][k];
    }

}
