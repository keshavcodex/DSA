package recursion.easy;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 8, 15, 65, 222};
        int target = 222;
        int index = search(arr, target, 0, arr.length);
        System.out.println(index);
    }
    static int search(int[] arr, int target, int s, int e){
        if(s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;

        if (arr[m] == target) {
            return m;
        }
        else if (target < arr[m]) {
            return search(arr, target, s, m - 1);
        }
        return search(arr, target, m + 1, e);
    }
}
