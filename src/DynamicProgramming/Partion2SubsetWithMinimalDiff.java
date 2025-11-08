package dynamicProgramming;

public class Partion2SubsetWithMinimalDiff {
    public static void main(String[] args) {
        int[] arr = {3, 9, 7, 3, 27};

        System.out.println("Subset with minimalDiff: " + subsetWithMinimalDiff(arr));
    }

    private static int subsetWithMinimalDiff(int[] arr) {
        int n = arr.length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            k += arr[i];
        }

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
        int minimum = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= k/2; s1++) {
            if(dp[n - 1][s1]) {
                minimum = Math.min(minimum, Math.abs((k - s1) - s1));
            }
        }

        return minimum;
    }
}
