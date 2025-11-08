package Practice.DP;

import helper.Timer;

public class FrogJump {
    static Integer[] dp;

    public static void main(String[] args) {
        int[] arr = {10, 30, 40, 50, 20};
        int n = arr.length;
        int k = 3;

        dp = new Integer[n + 1];

        Timer.start();
        int ans = minimalEffort(arr, 0, k);

        System.out.println(ans);
        System.out.println("effort: " + minimalEffort(arr, k));
        Timer.end();
    }

    private static int minimalEffort(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int minEffort = Integer.MIN_VALUE;
            for (int j = 1; j <= k; j++) {
                minEffort = Math.min(minEffort, Math.abs(arr[i] - arr[i - j]));
            }
        }
        return dp[n - 1];
    }

    private static int minimalEffort(int[] arr, int i, int k) {
        if (i == arr.length - 1) return 0;

        if (dp[i] != null) return dp[i];

        int jump = Integer.MAX_VALUE;

        for (int step = 1; step <= k; step++) {
            if(i + step >= arr.length) break;
            jump = Math.min(jump, minimalEffort(arr, i + step, k) + Math.abs(arr[i] - arr[i + step]));
        }

        return dp[i] = jump;

    }
}
