package Hashing;
import java.util.*;

public class HashSets {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        set.add(24);
        set.add(21);
        set.add(51);
        set.add(2);
        set.add(11);
        set.add(5);
        System.out.println(set);
        Iterator it = set.iterator();
        System.out.print(it.next() + " ");
        System.out.print(it.hasNext() + ", ");
        System.out.print(it.next() + " ");
        System.out.print(it.hasNext() + ", ");
        System.out.print(it.next() + " ");
        System.out.print(it.hasNext() + ", ");
        System.out.print(it.next() + " ");
        System.out.print(it.hasNext() + ", ");
        System.out.print(it.next() + " ");
        System.out.print(it.hasNext() + ", ");
        System.out.print(it.next() + " ");
        System.out.print(it.hasNext() + ", ");
    }
}
