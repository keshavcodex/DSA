package dynamicProgramming;

import helper.Timer;

import java.util.Arrays;

public class MinimumPathSum {
    static int n, m;
    static Integer[][] dp;
    public static void main(String[] args) {
        int[][] grid = inputArray();
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[n][m];


        Timer.start();
        System.out.println("Minimum Path sum recursion: " + minimumPathSumRecursion(0, 0, grid));
        System.out.println("Minimum Path sum tabulation: " + minimumPathSumTabulation(grid));
        Timer.end();
    }

    private static int[][] inputArray() {
        int[][] grid = {
                {5, 1, 8, 6, 3, 2, 9, 7, 4, 8, 5, 6, 7, 2, 1, 9, 3, 4, 8, 2},
                {4, 9, 7, 3, 2, 6, 8, 5, 1, 9, 4, 7, 6, 3, 2, 8, 5, 7, 1, 9},
                {6, 3, 2, 8, 9, 5, 7, 4, 3, 2, 1, 8, 6, 9, 7, 3, 5, 6, 4, 1},
                {7, 5, 9, 1, 4, 8, 6, 3, 2, 5, 9, 7, 8, 1, 3, 4, 2, 6, 5, 8},
                {2, 6, 3, 4, 5, 7, 9, 2, 8, 6, 5, 4, 3, 7, 8, 9, 1, 5, 2, 7},
                {8, 4, 6, 9, 1, 3, 2, 5, 7, 4, 8, 6, 9, 2, 1, 3, 5, 7, 8, 4},
                {9, 7, 4, 2, 3, 5, 6, 8, 1, 7, 9, 2, 4, 6, 5, 8, 7, 3, 9, 1},
                {3, 8, 5, 7, 9, 4, 2, 6, 3, 1, 5, 9, 7, 2, 8, 4, 9, 5, 1, 3},
                {1, 2, 9, 5, 8, 7, 3, 4, 6, 9, 1, 2, 5, 8, 4, 6, 2, 3, 7, 9},
                {6, 3, 8, 9, 2, 5, 1, 7, 8, 4, 3, 9, 2, 6, 5, 7, 9, 8, 4, 2},
                {7, 5, 4, 3, 8, 9, 6, 1, 5, 7, 2, 8, 3, 4, 9, 6, 1, 7, 3, 8},
                {7, 9, 5, 3, 8, 2, 4, 7, 9, 1, 5, 3, 8, 2, 4, 6, 9, 7, 2, 5}
        };
        System.out.println("Expected output: " + 116);
        return grid;
    }
    private static int minimumPathSumRecursion(int i, int j, int[][] grid) {
        if (i == n - 1 && j == m - 1) {
            return grid[i][j];
        }

        if (i == n || j == m) {
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != null) return dp[i][j];

        int right = minimumPathSumRecursion(i, j + 1, grid);
        int down = minimumPathSumRecursion(i + 1, j, grid);

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }
    private static int minimumPathSumTabulation(int[][] grid){
        Integer[][] dp2 = new Integer[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0 && j == 0) {
                    dp2[i][j] = grid[i][j];
                } else {
                    int up = (i > 0) ? dp2[i - 1][j]: Integer.MAX_VALUE;
                    int left = (j > 0) ? dp2[i][j - 1]: Integer.MAX_VALUE;

                    dp2[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
//        for(Integer[] ele: dp2){
//            System.out.println(Arrays.toString(ele));
//        }
        return dp2[n - 1][m - 1];

    }
}
