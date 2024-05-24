package DynamicProgramming;

import java.util.Arrays;

public class Fibonacci {
    static int count = 0;
    static int[] dp;
//    static int fibo(int n) {
//        if (n <= 1) return n;
//        if(dp[n] != -1) return dp[n];
//        count++;
//        return dp[n] = fibo(n - 1) + fibo(n - 2);
//    }

    public static void main(String[] args) {
        int n = 10;
        // memoization

//        dp = new int[n + 1];
//        Arrays.fill(dp, -1);
//        int ans = fibo(n);
//        System.out.println(ans);

        // tabulation
        int[] fib = new int[n + 1];
        fib[1] = fib[2] = 1;

        for (int i = 3; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            System.out.println(fib[i]);
        }
    }
}
