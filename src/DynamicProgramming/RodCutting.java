package dynamicProgramming;

public class RodCutting {
    static int fnCall = 0;
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int len = 8;
        Integer[] dp = new Integer[len + 1];

        System.out.println("Rec best price: " + bestPriceRec(0, price, len, dp));
//        System.out.println("Fn calls: " + fnCall);
        System.out.println("Tab best price: " + bestPriceTab(price, len));
    }

    private static int bestPriceTab(int[] price, int len) {
        int[] dp = new int[len + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                dp[j] = Math.max(dp[j], price[i - 1] + dp[j - i]);
            }
        }
        return dp[len];
    }

    private static int bestPriceRec(int i, int[] price, int len, Integer[] dp) {
        fnCall++;
        if (i == price.length - 1) return len/(i + 1) * price[i];

        if(dp[len] != null) return dp[len];

        int take = (len >= i + 1) ? bestPriceRec(i, price, len - (i + 1), dp) + price[i] : 0;
        int notTake = bestPriceRec(i + 1, price, len, dp);

        return dp[len] = Math.max(take, notTake);
    }
}
