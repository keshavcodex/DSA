package Practice.DP;

import java.util.Arrays;

public class Fibonacci {
    static Long[] dp;
    static Long fib(int n) {
        if(n <= 1) return (long) n;
        if(dp[n] != null) return dp[n];
        return dp[n] = fib(n - 1) + fib(n - 2);
    }
    public static void main(String[] args) {
        int n = 35;
        dp = new Long[n + 1];
        double start = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            Long ans = fib(i);
            System.out.print(ans + ", ");
        }
        double end = System.currentTimeMillis();

        System.out.println("\nTotal time: " + (end - start));


    }
}
