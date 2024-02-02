package Math;
import java.math.BigInteger;

public class BigIntegers {
    public static void main(String[] args) {
//        BigInteger A = new BigInteger("422337203685477580734523");
//        BigInteger B = new BigInteger("522323437203685477580734");
//        A = A.multiply(B);
//        System.out.println(A);
        System.out.println(factorial(50));
    }
    static BigInteger factorial(int n) {
        BigInteger ans = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }
}
