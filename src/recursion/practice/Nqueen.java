package recursion.practice;

import java.util.Arrays;

public class Nqueen {
    static boolean nqueen(int[][] board, int i){
        if (board.length == i) {
            display(board);
            return true;
        }
        for (int j = 0; j < board.length; j++) {
            if (canPlace(board, i, j)) {
                board[i][j] = 1;
                boolean success = nqueen(board, i + 1);
                if (success) {
                    return true;
                }
                // backtrack
                board[i][j] = 0;
            }
        }
        return false;
    }

    private static boolean canPlace(int[][] board, int x, int y) {
        //Column
        for (int k = 0; k < x; k++) {
            if (board[k][y] == 1) return false;
        }
        //Left diagonal
        int i = x;
        int j = y;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) return false;
            i--;
            j--;
        }
        i = x;
        j = y;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == 1) return false;
            i--;
            j++;
        }
        return true;
    }

    private static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[4][4];
        boolean ans = nqueen(board, 0);
        System.out.println(ans);
    }
}
