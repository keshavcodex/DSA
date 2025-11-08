package Practice.DP;

public class Knapsack01 {
    static int fnCount = 0;
    public static void main(String[] args) {
        int[] wt = {3, 2, 5, 4, 7, 5, 7, 8, 9, 12};
        int[] val = {30, 40, 60, 50, 70, 100, 40, 20, 80, 10};
        int capacity = 15;
        if(invalidInput(wt, val, capacity)) return;

        Integer[][] dp = new Integer[wt.length][capacity + 1];

        System.out.println("rec profit: " + knapsackRec(0, wt, val, capacity, dp));
        System.out.println("Tab profit: " + knapsackTab(wt, val, capacity));
        System.out.println("Function count: " + fnCount);
    }

    static int knapsackTab(int[] wt, int[] val, int capacity) {
        Integer[][] dp = new Integer[wt.length][capacity + 1];

        for (int c = 0; c <= capacity; c++) {
            if(wt[0] <= c) dp[0][c] = val[0];
            else dp[0][c] = 0;
        }

        for (int i = 1; i < wt.length; i++) {
            for (int c = 0; c <= capacity; c++) {
                int notTake = dp[i - 1][c];
                int take = (wt[i] <= c)? val[i] + dp[i - 1][c - wt[i]]: 0;

                dp[i][c] = Math.max(take, notTake);
            }
        }
        return dp[wt.length - 1][capacity];
    }

    private static boolean invalidInput(int[] wt, int[] val, int capacity) {
        if(wt.length != val.length){
            System.out.println("Invalid size of input");
            return true;
        }
        if(capacity < 0){
            System.out.println("Bag capacity can't be negative");
            return true;
        }
        return false;
    }

    private static int knapsackRec(int i, int[] wt, int[] val, int capacity, Integer[][] dp) {
        fnCount++;
        if (i == wt.length) return 0;

        if(dp[i][capacity] != null) return dp[i][capacity];

        int take = (capacity >= wt[i]) ? knapsackRec(i + 1, wt, val, capacity - wt[i], dp) + val[i] : 0;
        int notTake = knapsackRec(i + 1, wt, val, capacity, dp);

        return dp[i][capacity] = Math.max(take, notTake);
    }
}
