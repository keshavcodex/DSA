package dynamicProgramming.stocks;

public class BuyAndSellWithCooldown {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Rec max profit: " + maxProfit(0, prices, 1));
        System.out.println("Rec max profit: " + maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i + 1][0] - prices[i], dp[i + 1][1]);
            dp[i][0] = Math.max(dp[i + 2][1] + prices[i], dp[i + 1][0]);
        }
        return dp[0][1];
    }

    private static int maxProfit(int i, int[] prices, int canBuy) {
        if (i >= prices.length) return 0;

        if (canBuy == 1) {
            int buy = maxProfit(i + 1, prices, 0) - prices[i];
            int skip = maxProfit(i + 1, prices, canBuy);
            return Math.max(buy, skip);
        } else {
            int sell = maxProfit(i + 2, prices, 1) + prices[i];
            int skip = maxProfit(i + 1, prices, canBuy);
            return Math.max(sell, skip);
        }
    }
}
