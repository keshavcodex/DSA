package dynamicProgramming;

public class MinimumInsertionDeletion {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "anc";
        int n = s1.length();
        int m = s2.length();
        int ans = n + m - (2 * lcs(s1, s2));
        System.out.println("Minimum Insertion/deletion: " + ans);
    }

    private static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
