package recursion.arrayProblems;

public class SortedArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 12, 5};
        System.out.println(sorted(arr));
    }
    static boolean sorted(int[] arr, int index) {
        // base condition
        if( index == arr.length - 1) return true;
        return arr[index] < arr[index + 1] && sorted(arr, index + 1);
    }
    static boolean sorted(int[] arr) {
        return sorted(arr, 0);
    }
}

