package Backtracking;

public class PathCount {
    static int pathCount(int n, int m){
        if(n == 1 && m == 1) {
            return 1;
        }
        int right = 0, down = 0, diag = 0;
        if(n > 1) down = pathCount(n -1, m);
        if(m > 1) right = pathCount(n, m - 1);
        if(m > 1 && n > 1) diag = pathCount(n-1, m-1);

        return down + right + diag;
    }
    public static void main(String[] args) {
        int n = 2, m = 2;
        int ans = pathCount(n, m);
        System.out.println(ans);
    }
}
