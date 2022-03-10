package binary_Search;

public class  BitonicArray {
    public static void main(String[] args) {
        int[] arr = {-8,-5,-5,4,9,12,7,6,2,1};
        int ans = peakIndexInMountainArray(arr);
        System.out.println("Index: " + ans);
    }
    static int peakIndexInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) { //this is descending array
                end = mid;
            } else {
                start = mid + 1;    //this is ascending array
            }
        }
        return start;
    }
}
