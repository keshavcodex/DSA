package dynamicProgramming;

import helper.Timer;

import java.util.ArrayList;

public class LongestIncreasingSubseq {
    static ArrayList<Integer> ans = new ArrayList<>();
    static Integer[][] dp;
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        longestIncreasingSubseq(0, Integer.MIN_VALUE, arr, new ArrayList<>());
        System.out.println(ans);
        dp = new Integer[arr.length][arr.length];
        Timer.start();
        System.out.println("Rec Length: " + getMaxLengthOnly(0, -1, arr, dp));
        System.out.println("Tab Length: " + getMaxLengthOnly(arr));
        Timer.end();
    }

    private static int getMaxLengthOnly(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1 ; prev--) {
                int notTake = dp[i + 1][prev + 1];
                int take = 0;

                if(prev == -1 || arr[prev] < arr[i]) {
                    take = 1 + dp[i + 1][i + 1];
                }
                dp[i][prev + 1] = Math.max(notTake, take);
            }
        }
        return dp[0][0];
    }

    private static int getMaxLengthOnly(int i, int prev, int[] arr, Integer[][] dp) {
        if(i == arr.length) return 0;

        if(dp[i][prev + 1] != null) return dp[i][prev + 1];

        int notTake = getMaxLengthOnly(i + 1, prev, arr, dp);
        int take = 0;
        if(prev == -1 || arr[prev] < arr[i]) {
            take = 1 + getMaxLengthOnly(i + 1, i, arr, dp);
        }
        return dp[i][prev + 1] = Math.max(notTake, take);
    }

    private static void longestIncreasingSubseq(int i, int prev, int[] arr, ArrayList<Integer> list) {
        if (i == arr.length) {
            if(ans.size() < list.size()) {
                ans = new ArrayList<>(list);
            }
            return;
        }

        if (prev < arr[i]) {
            list.add(arr[i]);
            longestIncreasingSubseq(i + 1, arr[i], arr, list);
            list.removeLast();
        }
        longestIncreasingSubseq(i + 1, prev, arr, list);
    }
}
