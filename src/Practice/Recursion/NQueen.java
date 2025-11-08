package Practice.Recursion;

public class NQueen {

    static int n = 4;
    public static void main(String[] args) {
        int[][] board = new int[n][n];
        setQueens(board, 0);
    }
    private static void setQueens(int[][] board, int row) {
        if(row == n) {
            printBoard(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            if(isValidPosition(board, row, col)){
                board[row][col] = 1;
                setQueens(board, row + 1);
                board[row][col] = 0;
            }
        }
    }

    private static boolean isValidPosition(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if(board[i][col] == 1) return false;
        }

        // check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((board[i][j] == 0? '*': 'Q') + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.print("___");
        }
        System.out.println();

    }

}

