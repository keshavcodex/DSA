package udemy.backtracking;

import java.util.Scanner;

public class NQueenCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the board length: ");
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        int ans = nqueen(board, n, 0);

        System.out.println(ans);
    }
    static int nqueen(int[][] board, int n, int i) {
        if (n == i) {
            printBoard(board);
            return 1;
        }
        //recursion
        //try to place a queen in every row
        int ways = 0;
        for (int j = 0; j < n; j++) {
//            Whether the current i, j is safe or not
            if (canPlace(board, n, i, j)) {
                board[i][j] = 1;
                ways += nqueen(board, n, i + 1);
                //backtrack
                board[i][j] = 0;
            }
        }
        return ways;
    }

    private static boolean canPlace(int[][] board, int n, int i, int j) {
        //Column
        for (int k = 0; k < i; k++) {
            if (board[k][j] == 1) {
                return false;
            }
        }
        //left diag
        int x = i;
        int y = j;
        while (x >= 0 && y >= 0){
            if(board[x][y] == 1) return false;
            x--; y--;
        }

        //Right diag
        x = i;
        y = j;
        while (x >= 0 && y < n){
            if(board[x][y] == 1) return false;
            x--; y++;
        }
        return true;
    }

    static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int value = board[i][j];
                if (value == 1)
                    System.out.print(" Q");
                else System.out.print(" *");
            }
            System.out.println();
        }
        System.out.println();
    }
}

