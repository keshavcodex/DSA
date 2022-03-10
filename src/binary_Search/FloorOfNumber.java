package binary_Search;

public class FloorOfNumber {
    static int floorNum(int[] arr, int target){
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
        return end;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 45, 64, 128, 157};
        int target = 127;
        int ans = floorNum(arr, target);
        if(ans < 0) System.out.println("No element found");
        else System.out.println(arr[ans]);
    }
}
