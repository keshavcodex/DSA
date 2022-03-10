package recursion.arrayProblems;

import java.util.ArrayList;

public class FindAllIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 12, 5};
        System.out.println(findAllIndex(arr, 4, 0));
    }

    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) return list;
//      This will contain answer for that function call only
        if (arr[index] == target) {
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCall = findAllIndex(arr, target, index + 1);
        list.addAll(ansFromBelowCall);
        return list;
    }
}
