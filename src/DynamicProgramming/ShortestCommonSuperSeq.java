package dynamicProgramming;

public class ShortestCommonSuperSeq {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "abcgroot";

        System.out.println("Shortest common superSequence: " + scs(s1, s2));
    }

    private static String scs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

//        System.out.println("scs length: " + dp[n][m]);
//        for (int[] ele: dp) {
//            System.out.println(Arrays.toString(ele));
//        }

        StringBuilder sb = new StringBuilder();

        while(n > 0 && m > 0){
            if(s1.charAt(n - 1) == s2.charAt(m - 1)){
                n--;
                m--;
                sb.append(s1.charAt(n));
            } else {
                if(dp[n - 1][m] > dp[n][m - 1]){
                    n--;
                    sb.append(s1.charAt(n));
                } else {
                    m--;
                    sb.append(s2.charAt(m));
                }
            }
        }
        while(n > 0) {
            n--;
            sb.append(s1.charAt(n));
        }
        while(m > 0) {
            m--;
            sb.append(s2.charAt(m));
        }

        return sb.reverse().toString();
    }
}
