package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstNegative {
    public static void slidingWindow(int[] arr, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            int windowSize = j - i + 1;
            if (arr[j] < 0) {
                deque.offerLast(j);
            }
            if (windowSize == k) {
                if (deque.isEmpty())
                    System.out.print("0 ");
                else {
                    System.out.print(arr[deque.peekFirst()] + " ");
                    if(deque.peekFirst() == i){
                        deque.pollFirst();
                    }
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        slidingWindow(arr, k);
    }
}
