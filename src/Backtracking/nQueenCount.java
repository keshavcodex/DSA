package Backtracking;

import java.util.Scanner;

public class nQueenCount {
    private static int n;
    private static int[][] board;
    nQueenCount(int n){
        this.n = n;
        this.board = new int[n][n];
        int ans = solve(0);
        System.out.println("Total possible ways: " + ans);
    }
    private static int solve(int i){
        if(i == n) {
            printBoard();
            return 1;
        }
        int ways = 0;
        for (int j = 0; j < n; j++) {
            if(isSafe(i, j)){
                board[i][j] = 1;
                ways += solve(i + 1);
                board[i][j] = 0;  // backtracking
            }
        }
        return ways;
    }
    private static boolean isSafe(int i, int j){
        // Columns
        for (int k = 0; k < i; k++) {
            if(board[k][j] == 1) return false;
        }
//        // left diagonal
        for (int k = i, l = j; k >= 0 && l >= 0; k--, l--) {
            if(board[k][l] == 1) return false;
        }
//        // right diagonal
        for (int k = i, l = j; k >= 0 && l < n; k--, l++) {
            if(board[k][l] == 1) return false;
        }
        return true;
    }
    private static void printBoard() {
        for (int i = 0; i < n; i++) {
            System.out.print("__");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] == 1? "Q " : "* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of queens: ");
        int n = sc.nextInt();
        new nQueenCount(n);
    }
}
