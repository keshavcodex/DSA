package dynamicProgramming;

import java.util.Arrays;

public class LongestCommonSeqCount {
    public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadb";
        Integer[][] dp = new Integer[s1.length()][s2.length()];

        System.out.println("Longest Rec subseq count: " + longestSubSeqCount(0, s1, 0, s2, dp));
        System.out.println("Longest Tab subseq count: " + longestSubSeqCount(s1, s2));
    }

    private static int longestSubSeqCount(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[n][m];
    }

    private static int longestSubSeqCount(int i, String s1, int j, String s2, Integer[][] dp) {
        if (i == s1.length() || j == s2.length()) return 0;

        if (dp[i][j] != null) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + longestSubSeqCount(i + 1, s1, j + 1, s2, dp);
        return dp[i][j] = Math.max(longestSubSeqCount(i + 1, s1, j, s2, dp), longestSubSeqCount(i, s1, j + 1, s2, dp));
    }

}
