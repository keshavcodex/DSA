package udemy.backtracking;

public class Power {
    static int calcPower(int a, int n) {
        if(n == 0) return 1;
        return a * calcPower(a, n - 1);
    }

    static int fastPower(int a, int n) {
        if(n == 0) return 1;
        int subProb = fastPower(a, n / 2);
        int subProbSq = subProb * subProb;
        if ((n & 1) == 1) {
            return a * subProb;
        }
        return subProbSq;

    }
    public static void main(String[] args) {
        System.out.println(fastPower(2, 5));
        System.out.println(calcPower(2, 5));
    }
}
