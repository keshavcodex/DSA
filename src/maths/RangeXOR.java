package maths;

public class RangeXOR {
    public static void main(String[] args) {
        int a = 3;
        int b = 9;
        int ans = xor(b) ^ xor(a - 1);
        System.out.println(ans);
    }
    //this gives XOR from zero to a
    static int xor(int a){

        if (a % 4 == 0) {
            return a;
        } else if (a % 4 == 1) {
            return 1;
        } else if (a % 4 == 2) {
            return a + 1;
        }

        return 0;
    }
}
