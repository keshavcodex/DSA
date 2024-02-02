package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 45, 322, 345, 456, 563, 640, 902};
        BinarySearch obj = new BinarySearch();
        int targetIndex = 4;
//        int ans = obj.bs(arr, arr[targetIndex]);
        int ans = obj.bsIteration(arr, 3452);
        System.out.println(ans);
    }

    int bs(int[] arr, int target) {
        return bs(arr, target, 0, arr.length - 1);
    }

    int bs(int[] arr, int target, int s, int e) {
        if (e < s) return -1;
        int mid = (e - s) / 2 + s;
        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) {
            return bs(arr, target, s, mid - 1);
        } else return bs(arr, target, mid + 1, e);
    }

    int bsIteration(int arr[], int target) {
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = (e - s) / 2 + s;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) {
                s = mid + 1;
            } else e = mid - 1;
        }
        return -1;
    }

}
