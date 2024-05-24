package Math;

import java.util.Arrays;

public class TriangleNum {
    static int[] dp;
    static int triangleNumSum(int n) {
        if(dp[n] != -1) return dp[n];
        return dp[n] = n + triangleNumSum(n - 1);
    }

    public static void main(String[] args) {
        int n = 1001;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            System.out.println(triangleNumSum(i));
        }
    }
}
