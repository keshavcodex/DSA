package dynamicProgramming;

import helper.Timer;

public class CherryPickup {

    static int n, m;

    public static void main(String[] args) {
        int[][] grid = inputArray();
        n = grid.length;
        m = grid[0].length;

        Integer[][][] dp = new Integer[n][m][m];

        Timer.start();
        System.out.println("Recursion Sum: " + MaxSumRecursive(0, 0, m - 1, grid, dp));
        System.out.println("Tabulation Sum: " + MaxSumTabulation(grid));
        Timer.end();
    }

    private static int MaxSumTabulation(int[][] grid) {
        Integer[][][] dp = new Integer[n][m][m];

        // base case
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if(j1 == j2) dp[n - 1][j1][j2] = grid[n - 1][j1];
                else {
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }

        // bottom-up
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    int maxVal = (int) -1e8;

                    for (int d1 = -1; d1 <= 1 ; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int nextJ1 = j1 + d1;
                            int nextJ2 = j2 + d2;

                            int value = 0;
                            if(j1 == j2) value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];

                            if (nextJ1 >= 0 && nextJ1 < m && nextJ2 >= 0 && nextJ2 < m)
                                value += dp[i + 1][nextJ1][nextJ2];
                            else
                                value += (int) -1e8;

                            maxVal = Math.max(maxVal, value);
                        }
                    }
                    dp[i][j1][j2] = maxVal;
                }
            }
        }
        return dp[0][0][m - 1];
    }

    private static int MaxSumRecursive(int i, int j1, int j2, int[][] grid, Integer[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 == m || j2 == m) return (int) -1e8;
        if (i == n - 1) {
            if(j1 == j2) return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != null) return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;
        for (int moveA = -1; moveA <= 1; moveA++) {
            for (int moveB = -1; moveB <= 1; moveB++) {
                int value;
                if(j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];

                value += MaxSumRecursive(i + 1, j1 + moveA, j2 + moveB, grid, dp);
                max = Math.max(max, value);
            }
        }
        return dp[i][j1][j2] = max;

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
        System.out.println("Expected sum: " + 387);
        return grid;
    }

}
