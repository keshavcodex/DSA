package dynamicProgramming;

import java.util.Arrays;

public class kanpsack01 {
    public static void main(String[] args) {
        int[] wt = {1, 3, 5, 6};
        int[] val = {10, 5, 15, 20};
        int cap = 7;
        int dp[][] = new int[wt.length + 1][cap + 1];
//        int ans = kanpsackWithRecursion(wt, val, cap, wt.length);
        int ans = kanpsackWithMemoisation(wt, val, cap, wt.length, dp);
        System.out.println(ans);
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

    private static int kanpsackWithMemoisation(int[] wt, int[] val, int cap, int pos, int[][] dp) {
        if (cap == 0 || pos == 0) return 0;
        if (dp[pos][cap] != 0) {
            return dp[pos][cap];
        }
        int left = 0, right = 0;
        left = kanpsackWithMemoisation(wt, val, cap, pos - 1, dp);
        if (cap >= wt[pos - 1]) {
            right = kanpsackWithMemoisation(wt, val, cap - wt[pos - 1], pos - 1, dp) + val[pos - 1];
        }
        return dp[pos][cap] = Math.max(left, right);
    }

    private static int kanpsackWithRecursion(int[] wt, int[] val, int cap, int pos) {
        if (cap == 0 || pos == 0) return 0;
        int left = 0, right = 0;
        left = kanpsackWithRecursion(wt, val, cap, pos - 1);
        if (cap >= wt[pos - 1]) {
            right = kanpsackWithRecursion(wt, val, cap - wt[pos - 1], pos - 1) + val[pos - 1];
        }
        return Math.max(left, right);
    }
}
