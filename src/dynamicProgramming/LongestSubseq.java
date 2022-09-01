package dynamicProgramming;

public class LongestSubseq {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] a = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans,subseq(nums.length -1, a));
        }
        System.out.println(ans);
    }

    static int subseq(int i, int[] a) {
        int ans = 1;
        for (int j = 0; j < i; j++) {
            if(a[i] > a[j]){
                ans = Math.max(ans, subseq(i, a)+1);
            }
        }
        return ans;
    }
}
