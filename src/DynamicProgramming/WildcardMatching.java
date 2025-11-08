package dynamicProgramming;

import helper.Timer;

public class WildcardMatching {
    public static void main(String[] args) {
        String s = "acdcb";
        String p = "a*c?b";
//        String s = "bb";
//        String p = "****b";
        Boolean[][] dp = new Boolean[s.length()][p.length()];

        Timer.start();
        System.out.println("Rec Matching: " + match(0, 0, s, p, dp));
        System.out.println("Tab Matching: " + match(s, p));
        Timer.end();
    }

    private static boolean match(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            if(p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else dp[i][j] = false;
            }
        }
        return dp[n][m];
    }

    private static boolean match(int i, int j, String s, String p, Boolean[][] dp) {
        if(i == s.length() && j == p.length()) return true;
        if(i < s.length() && j == p.length()) return false;

        if(i == s.length()) {
            while(j < p.length()){
                if(p.charAt(j) != '*') return false;
                j++;
            }
            return true;
        }

        if(dp[i][j] != null) return dp[i][j];

        char c1 = s.charAt(i);
        char c2 = p.charAt(j);

        if(c2 == '?' || c1 == c2) {
            return dp[i][j] = match(i + 1, j + 1, s, p, dp);
        } else if(c2 == '*'){
            return dp[i][j] = match(i, j + 1, s, p, dp) || match(i + 1, j, s, p, dp);
        }
        return dp[i][j] = false;
    }
}
