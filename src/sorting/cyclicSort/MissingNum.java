package sorting.cyclicSort;

class MissingNum {
    public int missingNumber(int[] arr) {
        int i = 0;
        while(i < arr.length){
            if(arr[i] >= arr.length){
                i++;
            }else if(arr[i] != i){
                swap(arr, arr[i], i);
            }else i++;
        }
        i = 0;
        while(i < arr.length){
            if(i != arr[i]) return i;
            i++;
        }
        return arr.length;
    }
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}