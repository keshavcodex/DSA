package dynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapsack {
    public static void main(String[] args){
        int[] wt = {1, 4, 3, 5};
        int[] val = {10, 40, 50, 70};
        int cap = 50;
        int[] dp = new int[cap + 1];
        long start = System.currentTimeMillis();
        int ans = unboundedKnapsackWithRecursion(wt, val, cap);
//        int ans = unboundedKnapsackWithMemoisation(wt, val, cap, dp);
//        int ans = unboundedKnapsackWithTabulation(wt, val, dp);3.-
        long end = System.currentTimeMillis();
        System.out.println("Max profit: " + ans);
        System.out.println("Time Taken: " + (end-start));
        System.out.println(Arrays.toString(dp));
    }

    private static int unboundedKnapsackWithTabulation(int[] wt, int[] val, int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            if (i == 0) {
                dp[0] = 0;
                continue;
            }
            int ans = 0;
            for (int j = 0; j < wt.length; j++) {
                if (i - wt[j] >= 0) {
                    ans = Math.max(ans, dp[i - wt[j]]+val[j]);
                }
            }
            dp[i] = ans;
        }
        return dp[dp.length - 1];
    }

    private static int unboundedKnapsackWithMemoisation(int[] wt, int[] val, int cap, int[] dp) {
        if (cap == 0) {
            dp[0] = 0;
            return 0;
        }
        if (dp[cap] != 0) {
            return dp[cap];
        }
            int ans = 0;
        for (int i = 0; i < wt.length; i++) {
            if (cap - wt[i] >= 0) {
                ans = Math.max(ans, unboundedKnapsackWithMemoisation(wt, val, cap - wt[i], dp) + val[i]);
            }
        }
        return dp[cap] = ans;
    }
    private static int unboundedKnapsackWithRecursion(int[] wt, int[] val, int cap) {

        if (cap == 0) {
            return 0;
        }
            int ans = 0;
        for (int i = 0; i < wt.length; i++) {
            if (cap - wt[i] >= 0) {
                ans = Math.max(ans, unboundedKnapsackWithRecursion(wt, val, cap - wt[i]) + val[i]);
            }
        }
        return ans;
    }
}
