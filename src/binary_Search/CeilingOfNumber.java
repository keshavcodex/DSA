package binary_Search;

public class CeilingOfNumber {
    static int ceilingNum(int[] arr, int target){
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target > arr[mid]){
                start = mid + 1;
            }else if(target < arr[mid]){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 45, 64, 128, 157};
        int target = 75;
        int ans = ceilingNum(arr, target);
        if(ans >= arr.length) System.out.println("No element found");
        else System.out.println(arr[ans]);
    }
}
