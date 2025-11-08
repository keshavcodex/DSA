package Practice.Recursion;

public class SudokoSolver {
    static int n = 9;
    static int[][] board = new int[n][n];
    public static void main(String[] args) {
        fillBoard();
        solveSudoko(0, 0);
    }

    private static void fillBoard() {
        board[0][0] = 5;
        board[0][1] = 3;
        board[0][4] = 7;
        board[1][0] = 6;
        board[1][3] = 1;
        board[1][4] = 9;
        board[1][5] = 5;
        board[2][1] = 9;
        board[2][2] = 8;
        board[2][7] = 6;
        board[3][0] = 8;
        board[3][4] = 6;
        board[3][8] = 3;
        board[4][0] = 4;
        board[4][3] = 8;
        board[4][5] = 3;
        board[4][8] = 1;
        board[5][0] = 7;
        board[5][4] = 2;
        board[5][8] = 6;
        board[6][1] = 6;
        board[6][6] = 2;
        board[6][7] = 8;
        board[7][3] = 4;
        board[7][4] = 1;
        board[7][5] = 9;
        board[7][8] = 5;
        board[8][4] = 8;
        board[8][7] = 7;
        board[8][8] = 9;
    }

    private static boolean solveSudoko(int row, int col){
        if(row == n){
            printBoard();
            return true;
        }

        if(col == n) return solveSudoko(row + 1, 0);

        if(board[row][col] != 0) return solveSudoko(row, col + 1);

        for (int num = 1; num <= 9; num++) {
            if(isValid(row, col, num)) {

                board[row][col] = num;
                if(solveSudoko(row, col + 1)) return true;
                board[row][col] = 0;
            }
        }
        return false;
    }
    private static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < n; i++) {
            if(board[i][col] == num) return false;
            if(board[row][i] == num) return false;
        }

        row /= 3;
        row *= 3;

        col /= 3;
        col *= 3;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }
    private static void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.print("___");
        }
        System.out.println();

    }

}
