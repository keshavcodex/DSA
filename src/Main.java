import java.lang.reflect.Array;
import java.util.*;

class Main {
    static void printSubArray(int[] arr, int s, int e){
        for (int i = s; i <= e; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "1 2 2 3 -3 2 13 -9, 4";
        String[] arrayInput = input.split(",");
        int target = Integer.parseInt(arrayInput[1].trim());
        String[] arrayNum = arrayInput[0].split(" ");
        int[] arr = new int[arrayNum.length];
        for (int i = 0; i < arrayNum.length; i++) {
            arr[i] = Integer.parseInt(arrayNum[i]);
        }
        System.out.println("target: " + target);
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == target) {
                    printSubArray(arr, i, j);
                }
            }
        }
    }
}