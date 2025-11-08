package dynamicProgramming;

import java.util.HashSet;

public class LongestCommonSeq {
    public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadb";

        System.out.println("Longest subseq: " + longestSubSeqBruteF(s1, s2));
        System.out.println("Longest Tab subseq: " + longestSubSeq(s1, s2));
    }

    private static String longestSubSeq(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (n > 0 && m > 0) {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                sb.append(s1.charAt(n - 1));
                n--;
                m--;
            } else {
                if (dp[n - 1][m] > dp[n][m -1]) {
                    n--;
                } else {
                    m--;
                }
            }
        }

        return sb.reverse().toString();
    }

    private static String longestSubSeqBruteF(String s1, String s2) {
        HashSet<String> set = new HashSet<>();
        createSubSeq(s1, "", set);
        return findSubSeq(s2, "", set, "");
    }

    private static void createSubSeq(String str, String p, HashSet<String> set) {
        if (str.isEmpty()) {
            set.add(p);
            return;
        }
        createSubSeq(str.substring(1), p + str.charAt(0), set);
        createSubSeq(str.substring(1), p, set);
    }

    private static String findSubSeq(String str, String p, HashSet<String> set, String best) {
        if (str.isEmpty()) {
            if (set.contains(p) && p.length() > best.length()) return p;
            return best;
        }
        String take = findSubSeq(str.substring(1), p + str.charAt(0), set, best);
        String notTake = findSubSeq(str.substring(1), p, set, best);

        return take.length() > notTake.length() ? take : notTake;
    }


}
