package dynamicProgramming;

import java.util.Arrays;

public class TotalUniquePaths {
    static int n = 4, m = 3;
    static Integer[][] dp = new Integer[n][m];
    public static void main(String[] args) {
        double start = System.currentTimeMillis();
//        System.out.println("total number of Paths: "  + countPathsRecursion(0, 0));
//        System.out.println("total number of Paths: " + countPathsTabulation());
        System.out.println("total number of Paths: " + countPathsSpaceOptimised());
        double end = System.currentTimeMillis();
        System.out.println("time taken " + (end - start) + "ms");
//        for(Integer[] ele: dp) {
//            System.out.println(Arrays.toString(ele));
//        }
    }


    private static int countPathsRecursion(int i, int j) {
        if(i >= n || j >= m) return 0;
        if(i == n - 1 && j == m - 1) return 1;

        if(dp[i][j] != null) return dp[i][j];

        return dp[i][j] = countPathsRecursion(i, j + 1) + countPathsRecursion(i + 1, j);

    }

    private static int countPathsTabulation(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = (i > 0) ? dp[i - 1][j]: 0;
                    int left = (j > 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    private static int countPathsSpaceOptimised() {
        int[] prev = new int[m];

        for (int i = 0; i < n; i++) {
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                if(i == 0 && j == 0) temp[j] = 1;
                else {
                    int up = (i > 0)? prev[j] : 0;
                    int left = (j > 0)? temp[j - 1] : 0;
                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        return prev[m - 1];
    }
}
