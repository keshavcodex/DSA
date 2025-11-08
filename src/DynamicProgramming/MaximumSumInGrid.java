package dynamicProgramming;

import helper.Timer;

public class MaximumSumInGrid {
    static int n, m;

    public static void main(String[] args) {
        int[][] grid = inputArray();
        n = grid.length;
        m = grid[0].length;
        Integer[][] dp = new Integer[n][m];

        Timer.start();
        int recursiveAns = Integer.MIN_VALUE;
        for (int col = 0; col < m; col++) {
            recursiveAns = Math.max(recursiveAns, maxSumRecursion(0, col, grid, dp));
        }
        System.out.println("sum through Recursion: " + recursiveAns);

        System.out.println("Sum through Tabulation: " + maxSumTabulation(grid));
        Timer.end();
    }

    private static int maxSumTabulation(int[][] grid) {
        Integer[][] dp = new Integer[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) dp[i][j] = grid[i][j];
                else {
                    int leftUp = (j > 0) ? dp[i - 1][j - 1] : Integer.MIN_VALUE;
                    int up = dp[i - 1][j];
                    int rightUp = (j < m - 1) ? dp[i - 1][j + 1] : Integer.MIN_VALUE;

                    dp[i][j] = grid[i][j] + Math.max(leftUp, Math.max(up, rightUp));
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for (int col = 0; col < m; col++) {
            max = Math.max(max, dp[n - 1][col]);
        }
        return max;
    }

    private static int maxSumRecursion(int i, int j, int[][] grid, Integer[][] dp) {
        if (j < 0 || j == m) return Integer.MIN_VALUE;
        if (i == n - 1) return grid[i][j];

        if (dp[i][j] != null) return dp[i][j];

        int leftDiag = maxSumRecursion(i + 1, j - 1, grid, dp);
        int down = maxSumRecursion(i + 1, j, grid, dp);
        int rightDiag = maxSumRecursion(i + 1, j + 1, grid, dp);

        return dp[i][j] = grid[i][j] + Math.max(leftDiag, Math.max(down, rightDiag));
    }

    private static int[][] inputArray() {
        int[][] grid = {
                {10, 2, 3, 1, 5, 8, 40, 6, 9, 5, 7, 10, 2, 3, 11, 5},
                {3, 7, 2, 9, 4, 6, 1, 2, 10, 2, 3, 1, 5, 8, 40, 6},
                {8, 1, 5, 3, 2, 7, 9, 4, 10, 2, 3, 341, 5, 8, 40, 6},
                {9, 2, 6, 8, 5, 3, 7, 1, 10, 2, 13, 1, 5, 8, 40, 6},
                {4, 3, 8, 2, 6, 9, 5, 7, 10, 2, 3, 11, 5, 81, 40, 6},
                {7, 9, 1, 5, 3, 8, 2, 4, 10, 2, 3, 1, 5, 8, 40, 6},
                {2, 6, 4, 7, 9, 1, 3, 5, 10, 2, 113, 1, 5, 8, 40, 6},
                {5, 8, 7, 3, 4, 6, 2, 9, 10, 12, 3, 1, 5, 8, 40, 6}
        };
        System.out.println("Expected sum: " + 562);
        return grid;
    }

}
