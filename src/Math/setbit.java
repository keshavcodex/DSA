package Math;

public class setbit {
//    private static int setBitCount(int n){
//        int count = 0;
//
//        while(n != 0){
//            count += n % 2;
//            n /= 2;
//        }
//        return count;
//    }
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= 10; i++) {
            dp[i] = dp[i/2] + i % 2;
            System.out.println(dp[i]);
        }
    }
}
