package Practice.DP;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 20;

        int ans = countWays(n);
        System.out.println(ans);
    }

    private static int countWays(int n) {
        if(n <= 2) {
            return n;
        }

        return countWays(n - 1) + countWays(n - 2);
    }
}

