package dynamicProgramming;

import helper.Timer;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        Integer[][] dp = new Integer[s1.length()][s2.length()];

        Timer.start();
        System.out.println("Rec minimal Operation: " + minimalRecOperation(0, 0, s1, s2, dp));
        System.out.println("Tab minimal Operation: " + minimalRecOperation(s1, s2));
        Timer.end();
    }

    private static int minimalRecOperation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }

    private static int minimalRecOperation(int i, int j, String s1, String s2, Integer[][] dp) {
        if (i == s1.length()) return s2.length() - j;
        if (j == s2.length()) return s1.length() - i;

        if(dp[i][j] != null) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = minimalRecOperation(i + 1, j + 1, s1, s2, dp);
        }
        int min = Integer.MAX_VALUE;
        min = Math.min(min, minimalRecOperation(i + 1, j + 1, s1, s2, dp) + 1); //replace
        min = Math.min(min, minimalRecOperation(i, j + 1, s1, s2, dp) + 1); //insert
        min = Math.min(min, minimalRecOperation(i + 1, j, s1, s2, dp) + 1); //delete

        return dp[i][j] = min;
    }
}
