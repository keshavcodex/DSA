package Practice.DP;

public class NinjaTraining {

    public static void main(String[] args) {
        int[][] points = {
                {20, 40, 70}, 
                {120, 50, 80},
                {30, 60, 90},
                {40, 70, 100},
                {50, 80, 110}
        }; // ans = 460
        Integer[][] dp = new Integer[points.length][4];

        System.out.println("Rec Maximum score points: " + scoreRecursion(points, 0, 3, dp));

        System.out.println("Tab Maximum score points: " + scoreTabulation(points));
    }

    private static int scoreTabulation(int[][] points) {
        int n = points.length;
        int[][] dp = new int[points.length][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;

                for (int task = 0; task < 3; task++) {
                    if(task != last){
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }

    private static int scoreRecursion(int[][] points, int day, int last,Integer[][] dp) {
        if (day == points.length) return 0;

        if (dp[day][last] != null) return dp[day][last];

        int maximum = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last)
                maximum = Math.max(maximum, scoreRecursion(points, day + 1, task, dp) + points[day][task]);
        }
        return dp[day][last] = maximum;
    }


}