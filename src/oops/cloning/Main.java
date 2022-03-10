package oops.cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human kunal = new Human(34, "Kunal Kushwaha");
//        Human twin = new Human(kunal);
        Human twin = (Human)kunal.clone();
        System.out.println(twin.name + " " + twin.age + "\n" + Arrays.toString(twin.arr));
        twin.arr[0] = 100;
        System.out.println(kunal.name + " " + kunal.age + "\n" + Arrays.toString(kunal.arr));
//        System.out.println(Arrays.toString(kunal.arr));
    }
}
