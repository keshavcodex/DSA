package FUN;
import java.util.*;
public class pizzaTax {
    static void taxCalculation(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Pizzas: ");
        int numberOfPizza = sc.nextInt();
        double[] arr = new double[numberOfPizza];
        double pizzaPriceSum = 0;
        for (int i = 0; i < numberOfPizza; i++) {
            System.out.printf("Enter price of pizza %d: ", i+1);
            arr[i] = sc.nextDouble();
            pizzaPriceSum += arr[i];
        }
        System.out.print("Enter total bill amount: ");
        double totalBill = sc.nextDouble();
        for (int i = 0; i < numberOfPizza; i++) {
            int price = (int) Math.round(arr[i]/pizzaPriceSum * totalBill);
            System.out.printf("Price of pizza %d is: %d\n", (i+1), price);
        }
    }
    public static void main(String[] args){
        taxCalculation();
    }
}
