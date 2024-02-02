package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {23, 423, 23, 234, 13, 3423, 44, 5, 345, 3};
        int ans = orderAgnosticBS(arr, 44);
        System.out.println(ans);
    }

    static int orderAgnosticBS(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        boolean isAsc = arr[s] < arr[e];

        while (s <= e){
            int mid = (e - s) /2 + s;
            if(arr[mid] == target) return mid;
            if(isAsc) {
                if (arr[mid] > target) {
                    s = mid - 1;
                } else e = mid + 1;
            } else {
                if (arr[mid] < target) {
                    s = mid - 1;
                } else e = mid + 1;
            }
        }
        return -1;
    }

}
