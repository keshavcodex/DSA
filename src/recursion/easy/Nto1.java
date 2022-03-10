package recursion.easy;

public class Nto1 {
    public static void main(String[] args) {
        nTo1(5);
    }
    static void nTo1(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        nTo1(n - 1);
    }
}
