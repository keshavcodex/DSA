package Recursion;

public class Palindrome {
    static int isPalindrome(int n, int ans) {
        if (n == 0) return ans;
        ans = ans * 10 + n % 10;
        return isPalindrome(n / 10, ans);
    }

    static boolean isPalindrome(int n) {
        return n == isPalindrome(n, 0);
    }

    public static void main(String[] args) {
        int n = 12311;
        System.out.printf("Is %d Palindrome: %b", n, isPalindrome(n));
    }
}
