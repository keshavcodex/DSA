package dynamicProgramming;

public class Permutation {
    public static void main(String[] args){
        int[] arr = {1, 4, 3, 2};
        int target = 5;
//        int ans = permutationWithRecursion(arr, target, "");
        int[] dp = new int[target + 1];
//        int ans = permutationWithMemoisation(arr, target, dp);
        int ans = permutationWithTabulation(arr, dp);
        System.out.println("Count: " + ans);
    }

    private static int permutationWithTabulation(int[] arr, int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            if (i == 0){
                dp[i] = 1;
                continue;
            }
            int myAns = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i - arr[j] >= 0) {
                    myAns += dp[i - arr[j]];
                }
            }
            dp[i] = myAns;
        }
        return dp[dp.length - 1];
    }
    private static int permutationWithMemoisation(int[] arr, int target, int[] dp) {
        if(target == 0) return dp[target] = 1;
        if(dp[target] != 0) return dp[target];
        int myAns = 0;
        for (int ele: arr) {
            if(target - ele >= 0){
                myAns += permutationWithMemoisation(arr, target - ele, dp);
            }
        }
        return dp[target] = myAns;
    }

    private static int permutationWithRecursion(int[] arr, int target, String num) {
        if (target == 0) {
            System.out.println(num);
            return 1;
        }
        int myAns = 0;
        for (int ele : arr) {
            if (target - ele >= 0) {
                myAns += permutationWithRecursion(arr, target - ele, num+ele);
            }
        }
        return myAns;
    }


}
