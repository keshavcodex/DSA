package udemy.backtracking;

import java.util.Scanner;

public class GenerateBracates {
    static void generateBrackets(String output, int n, int open, int close, int i) {
        if (i == 2 * n) {
            System.out.println(output);
            return;
        }
        //Open
        if (open < n) {
            generateBrackets(output + '(', n, open+1, close, i+1);
        }
        //close
         if (close < open) {
            generateBrackets(output + ')', n, open, close+1, i+1);
        }
    }

    private static void generateBrackets(int n) {
        generateBrackets("", n, 0, 0, 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        generateBrackets(n);
    }
}
