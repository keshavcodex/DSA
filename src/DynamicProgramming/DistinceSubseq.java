package dynamicProgramming;

import helper.Timer;

import java.util.Arrays;

public class DistinceSubseq {
    public static void main(String[] args) {
        String s1 = "babgbagadfafabdfahfoanvnaofawofaWvav";
        String s2 = "bgfafv";
        Integer[][] dp = new Integer[s1.length()][s2.length()];

        Timer.start();
        System.out.println("Recursive Lcs count: " + lcsCountRec(0, 0, s1, s2, dp));
        System.out.println("Tabulation Lcs count: " + lcsCountTab(s1, s2));
        System.out.println("TabulationSpaceOptimised Lcs count: " + lcsCountTabSp(s1, s2));
        Timer.end();
    }

    private static int lcsCountTabSp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];
        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else curr[j] = prev[j];
            }
            prev = curr;
        }
        return prev[m];
    }


    private static int lcsCountTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }

    private static int lcsCountRec(int i, int j, String s1, String s2, Integer[][] dp) {
        if (j == s2.length()) return 1;
        if (i == s1.length()) return 0;
        if (dp[i][j] != null) return dp[i][j];

        int sum = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            sum = lcsCountRec(i + 1, j + 1, s1, s2, dp);
        }
        sum += lcsCountRec(i + 1, j, s1, s2, dp);
        return dp[i][j] = sum;
    }
}