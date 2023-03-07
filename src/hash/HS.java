package hash;
import java.util.HashSet;

public class HS {
    public static void main(String[] args) {
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int n = (int) (Math.random() * 20);
            s.add(n);
            System.out.print(n + ", ");
        }
        s.remove(3);
        System.out.println("\n" + s);
        System.out.println("size of s: " + s.size());
        System.out.println("s contains? " + s.contains(50));

    }
}