import java.util.ArrayList;

class Main {
    static boolean[][] dp;
    static boolean[][] visited;
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8,4,1, 10};
        int target = 10;
        dp = new boolean[arr.length + 1][target + 1];
        visited = new boolean[arr.length + 1][target + 1];

        subset(arr, 0, target, new ArrayList<>());

    }
    static private boolean subset(int[] arr, int i, int target, ArrayList<Integer> list){
        if(target == 0){
            System.out.println(list);
            return true;
        }
        if(i == arr.length || target < 0) return false;
        if(visited[i][target]) return dp[i][target];

        boolean exclude = subset(arr, i + 1, target, list);

        list.add(arr[i]);
        boolean include = subset(arr, i + 1, target - arr[i], list);
        list.remove(list.size() - 1);

        visited[i][target] = true;
        return dp[i][target] = exclude || include;
    }

}