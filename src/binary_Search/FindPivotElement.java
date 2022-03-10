package binary_Search;

public class FindPivotElement {
    public static void main(String[] args) {
        int[] arr = {-8, -5, -5, 4, 9, 12, 1, 2, 6, 7};
        findPivot(arr);
    }
    static int findPivot(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[start] > arr[mid]) {
                mid = mid - 1;
            } else if (arr[start] <= arr[mid]) {
                start  = mid + 1;
            }
        }
        return -1;
    }
}
