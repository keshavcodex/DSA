package recursion.arrayProblems;

public class Searching {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 12, 5};
        System.out.println(search(arr, 22));
    }
    static int search(int[] arr, int target){
        return search(arr, target, 0);
    }
    static int search(int[] arr, int target, int index){
        if(index == arr.length) return -1;
        else if (target == arr[index]) {
            return index;
        }
        return search(arr, target, index + 1);
    }
}
