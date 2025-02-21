import java.util.Arrays;

class Main {
    static int[][] dp;
    public static void main(String[] args) {
        int[] wt = {1, 3, 5, 6};
        int[] val = {10, 5, 15, 20};
        int w = 7;
        dp = new int[wt.length + 1][w + 1];
        System.out.println(knapsack(wt, val, w, wt.length));
        for (int[] ele: dp){
            System.out.println(Arrays.toString(ele));
        }
    }
    private static int knapsack(int[] wt, int [] val, int w, int n){
        if(n == 0 || w == 0) return 0;
        if(dp[n][w] != 0) return dp[n][w];

        int left = 0, right = 0;

        if(wt[n - 1] <= w) left = knapsack(wt, val, w - wt[n - 1], n - 1) + val[n - 1];
        right = knapsack(wt, val, w, n - 1);

        return dp[n][w] = Math.max(left, right);
    }

}