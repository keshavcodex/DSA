package udemy.backtracking;

public class TileProblem {
    public static void main(String[] args) {
        int numberOfTiles = 10;
        System.out.println(tiles(numberOfTiles));
    }

    static int tiles(int n) {
        if(n < 4) return 1;
        return tiles(n - 1) + tiles(n - 4);
    }
}
