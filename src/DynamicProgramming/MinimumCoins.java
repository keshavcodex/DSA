package dynamicProgramming;

import java.util.ArrayList;

public class MinimumCoins {
    static int fnCall = 0;
    static ArrayList<Integer> al = new ArrayList<>();

    public static void main(String[] args) {
        int[] coins = {9, 5, 6, 10, 1};
        int target = 19;
        Integer[][] dp = new Integer[coins.length][target + 1];

        System.out.println("Rec Minimum coins: " + minimumCoinsRec(0, coins, target, dp));
        System.out.println("Tab Minimum coins: " + minimumCoinsTab(coins, target));
        System.out.println("Function calls: " + fnCall);
    }

    private static int minimumCoinsTab(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target + 1];

        for (int j = 0; j <= target; j++) {
            if(j % coins[0] == 0) dp[0][j] = j/coins[0];
            else dp[0][j] = (int) 1e8;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int notTake = dp[i - 1][j];
                int take = (j >= coins[i]) ? dp[i][j - coins[i]] + 1 : Integer.MAX_VALUE;

                dp[i][j] += Math.min(notTake, take);
            }
        }

        return dp[n - 1][target];
    }

    private static int minimumCoinsRec(int i, int[] coins, int target, Integer[][] dp) {
        fnCall++;
        if (target == 0) {
            System.out.println(al);
            return 0;
        }
        if (i == coins.length || target < 0) return (int) 1e8;

        if (dp[i][target] != null) return dp[i][target];

        al.add(coins[i]);
        int take = minimumCoinsRec(i, coins, target - coins[i], dp) + 1;
        al.removeLast();

        int notTake = minimumCoinsRec(i + 1, coins, target, dp);

        return dp[i][target] = Math.min(take, notTake);
    }
}
