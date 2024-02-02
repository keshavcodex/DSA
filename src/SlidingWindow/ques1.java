package SlidingWindow;

public class ques1 {
    static void slidingWindow(int[] arr, int k) {
        int i = 0, j = 0;
        int maxSum = arr[0];
        int sum = 0;
        while (j < arr.length) {
            int window = j - i + 1;
            sum += arr[j];

            if (window < k) j++;
            else if (window == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        System.out.println("maxSum " + maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8, 2, 9, 1};
        int k = 3;
        slidingWindow(arr, k);
    }
}
