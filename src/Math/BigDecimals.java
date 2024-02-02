package Math;
import java.math.BigDecimal;

public class BigDecimals {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("234.345645");
        BigDecimal b = new BigDecimal("4657234.345645");
        System.out.println(a);
        a = a.multiply(b);
        System.out.println(a.pow(23));
    }
}
