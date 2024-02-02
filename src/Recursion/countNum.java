package Recursion;

import java.util.Scanner;

public class countNum {
    static int countNumber(int n, int count, int target) {
        if (n == 0) return count;
        if (n % 10 == target) count++;
        return countNumber(n/10, count, target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1232989129;
        System.out.print("Enter the target Number: ");
        int target = sc.nextInt();
        System.out.println("count of " + target + " is: " + countNumber(n, 0, target));
    }
}
