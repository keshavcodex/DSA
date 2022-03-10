import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
        HelloWorld obj = new HelloWorld();

        int result = sum(6, 8);
        System.out.println(result);
        System.out.println(sum(49,51));
    }

    static int sum(int x, int y) {
        return x + y;
    }
}
