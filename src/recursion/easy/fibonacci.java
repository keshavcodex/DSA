package recursion.easy;

public class fibonacci {
    public static void main(String[] args) {
        int n = 40;
        int a = 0, b = 1, sum = 0;
        while(n-- > 1) {
            sum = a + b;
            a = b;
            b = sum;
        }
        System.out.println("loop: " + sum);
        int ans = fibo(n);
        System.out.println(ans);
    }
    static int fibo(int n){
        if (n < 2) return n;
       return fibo(n - 1) + fibo(n - 2);
    }
}

