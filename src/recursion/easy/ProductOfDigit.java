package recursion.easy;

public class ProductOfDigit {
    public static void main(String[] args){
        int n = 5236;
        System.out.println(digitProduct(n));
    }
    static int digitProduct(int n){
        if(n <= 1){
            return 1;
        }
        return n % 10 * digitProduct(n / 10);
    }
}
