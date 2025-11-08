package dynamicProgramming.stocks;

import java.util.Arrays;

public class BestTimeToBuySell3 {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int cap = 2;
        System.out.println("Rec Maximum profit: " + maxProfit(0, prices, 1, cap));
        System.out.println("Tab Maximum profit: " + maxProfit(prices, cap));
    }

    private static int maxProfit(int[] prices, int cap) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][cap + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= cap; j++) {

                dp[i][1][j] = Math.max(-prices[i] + dp[i + 1][0][j], dp[i + 1][1][j]);

                dp[i][0][j] = Math.max(prices[i] + dp[i + 1][1][j - 1], dp[i + 1][0][j]);
            }
        }
        for (int[][] dpEle : dp) {
            for (int[] ele : dpEle) {
                System.out.println(Arrays.toString(ele));
            }
        }
        return dp[0][1][cap];
    }

    private static int maxProfit(int i, int[] prices, int buy, int cap) {
        if (i == prices.length || cap == 0) return 0;

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(maxProfit(i + 1, prices, 0, cap) - prices[i], maxProfit(i + 1, prices, buy, cap));
        } else {
            profit = Math.max(maxProfit(i + 1, prices, 1, cap - 1) + prices[i], maxProfit(i + 1, prices, buy, cap));
        }
        return profit;
    }

}
