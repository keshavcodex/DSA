package Recursion;

public class ReverseNum {
    static int reverseNum (int n, int ans) {
        if(n == 0) return ans;
        ans = ans * 10 + n % 10;
        return reverseNum(n / 10, ans);
    }
    public static void main(String[] args) {
        int n = 12345;
        System.out.println(reverseNum(n, 0));
    }
}
