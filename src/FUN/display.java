package FUN;
import java.util.Scanner;

public class display {
    static Scanner sc = new Scanner(System.in);
    static void functionSelection(){
        System.out.println("Press 1, if you have diagonal only");
        System.out.println("Press 2, if you have ratio and diagonal");
        System.out.println("Press 3, if you have have length and breadth");
        int n = sc.nextInt();
        if(n == 1){
            findScreen169();
        } else if(n == 2){
            findScreen();
        } else if(n == 3){
            findDiagonal();
        } else {
            functionSelection();
        }
    }
    static void findScreen(){
        System.out.print("Enter 1st aspect ratio: ");
        double ratio1 = sc.nextDouble();
        System.out.print("Enter 2nd aspect ratio: ");
        double ratio2 = sc.nextDouble();
        System.out.print("Enter the diagonal: ");
        double diagonal = sc.nextDouble();
        findScreen(ratio1, ratio2, diagonal);
    }
    static void findScreen169(){
        System.out.println("Enter the diagonal: ");
        double diagonal = sc.nextDouble();
        findScreen(16, 9, diagonal);
    }
    static void findScreen(double ratio1, double ratio2, double diagonal){
        double side1 = Math.sqrt(Math.pow(diagonal, 2) / (1+Math.pow((ratio2 / ratio1),2)));
        double side2 = ratio2*side1/ratio1;
        System.out.printf("Length is: %.2f\n", side1);
        System.out.printf("Breadth is: %.2f\n", side2);
    }
    static void findDiagonal(){
        System.out.print("Enter length: ");
        double length = sc.nextDouble();
        System.out.print("Enter breadth: ");
        double breadth = sc.nextDouble();
        System.out.println("Diagonal is: " + Math.sqrt(length * length + breadth * breadth));
    }

    public static void main(String[] args) {
        functionSelection();
    }
}
