package Practice.DP;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] wt = {2, 4, 6};
        int[] val = {5, 11, 13};
        int cap = 10;
        Integer[][] dp = new Integer[wt.length][cap + 1];

        System.out.println("Rec UnboundedKnapsack: " + knapsackRec(0, wt, val, cap, dp));
        System.out.println("Tab UnboundedKnapsack: " + knapsackTab(wt, val, cap));
    }

    private static int knapsackTab(int[] wt, int[] val, int cap) {
        int n = wt.length;
        int[][] dp = new int[n][cap + 1];

        for (int j = 0; j <= cap; j++) {
            dp[0][j] = (j / wt[0]) * val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= cap; j++) {
                int take = (j >= wt[i]) ? dp[i][j - wt[i]] + val[i] : 0;
                int notTake = dp[i - 1][j];

                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][cap];
    }

    private static int knapsackRec(int i, int[] wt, int[] val, int cap, Integer[][] dp) {
        if (i == wt.length - 1) {
            return (cap/wt[wt.length - 1]) * val[wt.length - 1];
        }
        if (dp[i][cap] != null) return dp[i][cap];

        int take = (cap >= wt[i]) ? knapsackRec(i, wt, val, cap - wt[i], dp) + val[i] : 0;
        int notTake = knapsackRec(i + 1, wt, val, cap, dp);

        return dp[i][cap] = Math.max(take, notTake);
    }
}
