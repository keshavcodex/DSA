package dynamicProgramming;

import helper.Timer;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
    static Integer[][] dp;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = triangleInput();
        int n = list.size();
        dp = new Integer[n][n];

        Timer.start();
        System.out.println("Sum Recursion: " + minimumPathSumRecursion(0, 0, list));
        System.out.println("Sum Tabulation: " + minimumPathSumTabulation(list));

        Timer.end();
    }

    private static int minimumPathSumTabulation(ArrayList<ArrayList<Integer>> list) {
        int n = list.size();
        Integer[][] dp2 = new Integer[n][n];

        dp2[0][0] = list.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                int up = (i > j) ? dp2[i - 1][j] : Integer.MAX_VALUE;
                int diagUp = (j > 0) ? dp2[i - 1][j - 1] : Integer.MAX_VALUE;

                dp2[i][j] = Math.min(up, diagUp) + list.get(i).get(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < list.get(n - 1).size(); j++) {
            min = Math.min(min, dp2[n - 1][j]);
        }
        return min;
    }

    private static int minimumPathSumRecursion(int i, int j, ArrayList<ArrayList<Integer>> list) {
        if (i == list.size() - 1) {
            return list.get(i).get(j);
        }
        if (dp[i][j] != null) return dp[i][j];

        int down = minimumPathSumRecursion(i + 1, j, list);
        int diag = minimumPathSumRecursion(i + 1, j + 1, list);

        return dp[i][j] = Math.min(down, diag) + list.get(i).get(j);
    }


    private static ArrayList<ArrayList<Integer>> triangleInput() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(2, 3)));
        list.add(new ArrayList<>(Arrays.asList(3, 6, 7)));
        list.add(new ArrayList<>(Arrays.asList(8, 9, 6, 10)));
        list.add(new ArrayList<>(Arrays.asList(4, 2, 7, 3, 6)));
        list.add(new ArrayList<>(Arrays.asList(5, 8, 9, 2, 1, 4)));
        list.add(new ArrayList<>(Arrays.asList(9, 3, 5, 7, 6, 2, 8)));
        list.add(new ArrayList<>(Arrays.asList(6, 4, 1, 8, 5, 9, 7, 3)));
        list.add(new ArrayList<>(Arrays.asList(7, 2, 9, 4, 6, 3, 1, 8, 5)));
        list.add(new ArrayList<>(Arrays.asList(8, 5, 3, 9, 2, 4, 6, 7, 1, 9)));
        list.add(new ArrayList<>(Arrays.asList(9, 7, 4, 2, 5, 3, 8, 6, 9, 1, 7)));
        list.add(new ArrayList<>(Arrays.asList(4, 1, 8, 9, 6, 5, 2, 3, 7, 8, 4, 6)));
        list.add(new ArrayList<>(Arrays.asList(3, 5, 7, 2, 8, 4, 1, 6, 9, 5, 2, 3, 7)));
        list.add(new ArrayList<>(Arrays.asList(6, 9, 1, 3, 7, 2, 8, 4, 5, 6, 3, 9, 2, 4)));
        list.add(new ArrayList<>(Arrays.asList(2, 4, 6, 5, 9, 1, 3, 7, 2, 8, 5, 9, 4, 1, 6)));
        list.add(new ArrayList<>(Arrays.asList(2, 4, 6, 5, 9, 1, 3, 7, 2, 8, 5, 9, 4, 1, 6, 7)));
        list.add(new ArrayList<>(Arrays.asList(2, 4, 6, 5, 9, 1, 3, 7, 2, 8, 5, 9, 4, 1, 6, 7, 2)));
        list.add(new ArrayList<>(Arrays.asList(2, 4, 6, 5, 9, 1, 3, 7, 2, 8, 5, 9, 4, 1, 6, 4, 5, 6)));
        list.add(new ArrayList<>(Arrays.asList(2, 4, 6, 5, 9, 1, 3, 7, 2, 8, 5, 9, 4, 1, 6, 7, 2, 8, 4)));
        list.add(new ArrayList<>(Arrays.asList(2, 4, 6, 5, 9, 1, 3, 7, 2, 8, 5, 9, 4, 1, 6, 7, 2, 8, 4, 5)));
        list.add(new ArrayList<>(Arrays.asList(2, 4, 6, 5, 9, 1, 3, 7, 2, 8, 5, 9, 4, 1, 6, 7, 2, 8, 4, 5, 6)));

        System.out.println("Expected output: " + 54);
        return list;
    }

}
