package udemy.backtracking;

import java.util.Arrays;

public class SuodokuCode {
    static boolean solveSudoku(int mat[][], int i, int j) {
        int n = mat.length;
        if (i == n) {
            display(mat);
            return true;
        }
        if(j == n) return solveSudoku(mat, i + 1, 0);
        // skip the prefilled cell
        if (mat[i][j] != 0) {
            return solveSudoku(mat, i, j + 1);
        }
        // cell to be filled
        for (int no = 1; no <= n; no++) {
            if (isSafe(mat, i, j, no)) {
                mat[i][j] = no;
                boolean solveSubProblem = solveSudoku(mat, i, j + 1);
                if (solveSubProblem) {
                    return true;
                }
//                return solveSubProblem;
            }
        }
        // if no option works
        mat[i][j] = 0;
        return false;
    }

    private static void display(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    private static boolean isSafe(int[][] mat, int i, int j, int no) {
        // check for row and col
        for (int k = 0; k < mat.length; k++) {
            if (mat[k][j] == no || mat[i][k] == no) {
                return false;
            }
        }
        // check for subgrid
        int sx = (i / 3) * 3;
        int sy = (j / 3) * 3;
        for (int x = sx; x < sx + 3; x++) {
            for (int y = sy; y < sy + 3; y++) {
                if(mat[x][y] == no) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat =  {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                        {6, 0, 0, 1, 9, 5, 0, 0, 0},
                        {0, 9, 8, 0, 0, 0, 0, 6, 0},
                        {8, 0, 0, 0, 6, 0, 0, 0, 3},
                        {4, 0, 0, 8, 0, 3, 0, 0, 1},
                        {7, 0, 0, 0, 2, 0, 0, 0, 6},
                        {0, 6, 0, 0, 0, 0, 2, 8, 0},
                        {0, 0, 0, 4, 1, 9, 0, 0, 5},
                        {0, 0, 0, 0, 8, 0, 0, 7, 9}};

        boolean ans = solveSudoku(mat, 0, 0);
        if(!ans) System.out.println("No solution exit");
    }
}
