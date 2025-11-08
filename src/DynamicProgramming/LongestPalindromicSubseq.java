package dynamicProgramming;

public class LongestPalindromicSubseq {
    public static void main(String[] args) {
        String s1 = "bbabcbcab";
        String s2 = reverseString(s1);
        System.out.println("Longest palindrome: " + longestPalindrome(s1, s2));
    }

    private static String longestPalindrome(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(n > 0 && m > 0) {
            if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
                sb.append(s1.charAt(n - 1));
                n--;
                m--;
            } else {
                if(dp[n - 1][m] > dp[n][m - 1]) n--;
                else m--;
            }
        }

        return sb.reverse().toString();
    }

    private static String reverseString(String s) {
        char[] str = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n/2; i++) {
            char temp = str[i];
            str[i] = str[n - 1 - i];
            str[n - 1 - i] = temp;
        }

        return new String(str);
    }


}
