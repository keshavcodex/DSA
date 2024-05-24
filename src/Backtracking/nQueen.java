package Backtracking;

import java.sql.SQLOutput;
import java.util.Scanner;

public class nQueen {
    private static int n;
    private static int[][] board;
    nQueen(int n) {
        this.n = n;
        this.board = new int[n][n];
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if(solve(i)) count++;
//            System.out.println("__________________");
//        }
//        System.out.println("Total possible variations are: " + count);
        solve(0);
    }

    static boolean solve(int i) {
        if(i == n) {
            printQueen();
            return true;
        }
        for (int j = 0; j < n; j++) {
            if(isSafe(i, j)){
                board[i][j] = 1;
                boolean success = solve(i + 1);
                if(success) return true;
            }
            board[i][j] = 0;
        }
        return false;
    }
    private static boolean isSafe(int i, int j){
        //Column
        for (int k = 0; k < i; k++) {
            if(board[k][j] == 1) return false;
        }
        // Left Diagonal
        for (int k = 0, l = 0; k < j && l < j; k++, l++) {
            if(board[k][l] == 1) return false;
        }
        // Right Diagonal
        for (int k = 0, l = n - 1; k < i && l > j; k++, l--) {
            if(board[k][l] == 1) return false;
        }
        return true;
    }   
    
    private static void printQueen(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : "* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of board: ");
        int n = sc.nextInt();
//        int n = 4;
//        System.out.println();
        new nQueen(n);
    }
}
