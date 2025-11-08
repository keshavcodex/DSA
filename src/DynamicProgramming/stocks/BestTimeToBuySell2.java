package dynamicProgramming.stocks;

import java.util.Arrays;

public class BestTimeToBuySell2 {
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3, 1, 4, 7, 2, 5, 8, 6, 7, 3, 9, 10, 8, 4, 6,
                9, 12, 3, 1, 4, 7, 2, 8, 9, 3, 6, 2, 4, 9, 11, 10, 13, 5, 2, 6,
                8, 9, 15, 3, 1, 6, 8, 11, 4, 2};
        Integer[][] dp = new Integer[prices.length][2];
        System.out.println("Rec Profit sum: " + buySellStock(0, prices, 1, dp));
        System.out.println("Tab Profit sum: " + buySellStock(prices));
    }

    private static int buySellStock(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0 ; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = (buy == 1)? dp[i + 1][1 - buy] - prices[i]: dp[i + 1][1 - buy] + prices[i];
                dp[i][buy] = Math.max(profit, dp[i + 1][buy]);
            }
        }
        for (int[] ele : dp) {
            System.out.println(Arrays.toString(ele));
        }
        return dp[0][1];
    }

    private static int buySellStock(int i, int[] prices, int canBuy, Integer[][] dp) {
        if (i == prices.length) return 0;
        if (dp[i][canBuy] != null) return dp[i][canBuy];

        int profit = 0;
        if (canBuy == 1) {
            profit = buySellStock(i + 1, prices, 1 - canBuy, dp) - prices[i];
        } else {
            profit = buySellStock(i + 1, prices, 1 - canBuy, dp) + prices[i];
        }
        profit = Math.max(profit, buySellStock(i + 1, prices, canBuy, dp));

        return dp[i][canBuy] = profit;
    }
}
