package binary_Search;

public class OrderAgnosticsBS {
    static int orderAgnosticsBS(int[] arr, int target){
        int start = 0, end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            int mid = start + (end - start) / 2;
            if (isAsc) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else {
                if (target < arr[mid]) {
                    start = mid + 1;
                } else if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1577,1284,644, 20, 8, 5, 4};
        int target = 1284;
        int ans = orderAgnosticsBS(arr, target);
        System.out.println(ans);
    }
}
