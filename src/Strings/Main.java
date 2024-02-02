package Strings;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(20);
        sb.append("abcdefgh");
        sb.replace(4, sb.length() , ", keshav");
        sb.delete(2, 4);
        String  str = sb.toString();
        System.out.println(str);

        Random random = new Random();
        int n  = (int)(26 * random.nextFloat()) + 97;
        System.out.println(n);
        char ch = (char) n;
        System.out.println(ch);
    }
}
