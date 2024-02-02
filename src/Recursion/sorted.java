package Recursion;

import java.util.Arrays;

public class sorted {
    static boolean isArraySorted(int [] num, int index){
        if(index == num.length - 2) return true;
        if(num[index] > num[index + 1]) return false;
        return isArraySorted(num, ++index);
    }
    static boolean isArraySorted(int [] num){
        return isArraySorted(num, 0);
    }

    public static void main(String[] args) {
        int [] arr = {12,123,34,2,234,23,43,4};
//        Arrays.sort(arr);
        System.out.println("isArraySorted: " + isArraySorted(arr));
    }
}
