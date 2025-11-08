package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSum {
    static int iteration = 0;
    static boolean[][] dp;
    static boolean[][] visited;
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 7, 3, 4};
        int target = 12;
        dp = new boolean[arr.length + 1][target + 1];
        visited = new boolean[arr.length + 1][target + 1];

        subsetSum(arr, target, 0, new ArrayList<Integer>());
        System.out.println("iteration: " + iteration);
    }
    private static boolean subsetSum(int[] arr, int target, int i, ArrayList<Integer> al) {
        iteration++;
        if(target == 0){
            System.out.println(al);
            return true;
        }
        if(i == arr.length || target < 0) return false;
        if(visited[i][target]) return dp[i][target];

        al.add(arr[i]);
        boolean include = subsetSum(arr, target - arr[i], i + 1, al);
        al.remove(al.size() - 1);

        boolean exclude = subsetSum(arr, target, i + 1, al);

        visited[i][target] = true;
        return dp[i][target] = include || exclude;
    }
}
