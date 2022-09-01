package udemy.backtracking;

public class NQueen {
    public static void main(String[] args) {
        int[][] board = new int[4][4];
        int n = 4;
        boolean ans = nqueen(board, n, 0);

        System.out.println(ans);
    }
    static boolean nqueen(int[][] board, int n, int i) {
        if (n == i) {
            printBoard(board);
            return true;
        }
        //recursion
        //try to place a queen in every row
        for (int j = 0; j < n; j++) {
//            Whether the current i, j is safe or not
            if (canPlace(board, n, i, j)) {
                board[i][j] = 1;
                boolean success = nqueen(board, n, i + 1);
                if(success) return true;
                //backtrack
                board[i][j] = 0;
            }
        }
        return false;
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
    }
}

