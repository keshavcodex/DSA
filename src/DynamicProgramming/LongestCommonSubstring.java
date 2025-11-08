package dynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";

        System.out.println("Longest common substring: " + longestCommonSubstring(s1, s2));

    }

    private static String longestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        int max = 0, endIndex = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                if(dp[i][j] > max) {
                    endIndex = i;
                    max = dp[i][j];
                }
            }
        }
        return s1.substring(endIndex - max, endIndex);
    }
}
