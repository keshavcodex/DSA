package udemy.backtracking;

import java.util.Scanner;

public class FibTabu {
    static int fibTabu(int[]fib, int n) {
        fib[0] = 0;
        if(n < 2) return fib[n];
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a num: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int[] fib = new int[i + 1];
            int ans = fibTabu(fib, i);
            System.out.println(i+1 + ": " + ans);
        }
    }
}
