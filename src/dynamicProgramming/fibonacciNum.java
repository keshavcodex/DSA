package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class fibonacciNum {
    public static void main(String[] args) {
        int n = 45;
        int[] dp = new int[n + 1];
        long s = System.currentTimeMillis();
        System.out.println(fib(n,dp));
        long e = System.currentTimeMillis();
        System.out.println(e-s);
    }

    private static int fibRec(int n) {
        if (n <= 1) return n;
        return fibRec(n - 1) + fibRec(n - 2);
    }
    private static int fib(int n, int[] dp) {
        if (n <= 1) return dp[n] = n;
        if(dp[n] != 0) return dp[n];
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }

    private static int fib_tabulation(int n, int[] dp) {
        for (int i = 0; i <= n; i++) {
            if (i <= 1) {
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}