package dynamicProgramming;


import java.util.Arrays;

public class CountSubseq {

    static int fnCallCount = 0;

    public static void main(String[] args) {
        int[] arr = {0, 0, 1};
        int target = 1;
        Integer[][] dp = new Integer[arr.length][target + 1];

        System.out.println("Recursive count: " + countSubseqRec(0, arr, target, dp));
        System.out.println("Tabulation count: " + countSubseqTab(arr, target));
        System.out.println("SpaceOPT Tabulation count: " + countSubseqTabSP(arr, target));
//        System.out.println(fnCallCount);
    }

    private static int countSubseqTabSP(int[] arr, int target) {
        int n = arr.length;
        int[] prev = new int[target + 1];

        prev[0] = 1;
        if (arr[0] <= target) prev[arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            int[] curr = new int[target + 1];
            curr[0] = 1;
            for (int j = 1; j <= target; j++) {
                int taken = (j >= arr[i]) ? prev[j - arr[i]] : 0;
                int notTaken = prev[j];
                curr[j] += taken + notTaken;
            }
            prev = curr;
        }
        return prev[target];
    }

    private static int countSubseqTab(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        if (target >= arr[0]) dp[0][arr[0]] = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                int take = (j >= arr[i]) ? dp[i - 1][j - arr[i]] : 0;
                int notTake = dp[i - 1][j];
                dp[i][j] += take + notTake;
            }
        }

        return dp[arr.length - 1][target];
    }

    private static int countSubseqRec(int i, int[] arr, int target, Integer[][] dp) {
        fnCallCount++;
        if (target == 0) return 1;
        if (i == arr.length) return 0;

        if (dp[i][target] != null) return dp[i][target];

        int take = (target >= arr[i]) ? countSubseqRec(i + 1, arr, target - arr[i], dp) : 0;
        int notTake = countSubseqRec(i + 1, arr, target, dp);

        return dp[i][target] = take + notTake;
    }

}

//subset count with given difference
//s1 + s2 = ts;
//=> s1 = ts - s2;
//
//s1 - s2 = D;
//=> ts - s2 - s2 = D;
//=>ts - d = 2 s2
//=> (ts - d)/2 = s2;
