package Practice.DP;

// Maximum sum of non-adjacent elements
public class HouseRobber2 {
    static Integer[] dp;

    public static void main(String[] args) {
//        int[] arr = {6, 18, 3, 9, 10, 20, 2, 17, 4, 8,
//                8, 10, 14, 3, 9, 17, 5, 20, 12, 15};  //ans = 138

        int[] arr = {5};

        dp = new Integer[arr.length + 1];
        int ans = 0;
        if (arr.length == 1) ans = arr[0];
        else {
            int ans1 = maximumSum(1, arr.length - 1, arr);
            int ans2 = maximumSum(0, arr.length - 2, arr);
            ans = Math.max(ans1, ans2);
        }
        System.out.println("maximumSum: " + ans);
    }

    private static int maximumSum(int i, int n, int[] arr) {
        if (i > n) return 0;

        if (dp[i] != null) return dp[i];

        int picked = maximumSum(i + 2, n, arr) + arr[i];
        int notPicked = maximumSum(i + 1, n, arr);

        return dp[i] = Math.max(picked, notPicked);
    }
}
