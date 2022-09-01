package udemy.backtracking;

public class TowerOfhanoi {
    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, 'A', 'B', 'C');
    }

    static void towerOfHanoi(int n, char from, char helper, char to) {
        if(n == 0) return;
        towerOfHanoi(n - 1, from, to , helper);
        System.out.println(from + " -> " + to) ;
        towerOfHanoi(n - 1, helper, from, to);
    }
}
