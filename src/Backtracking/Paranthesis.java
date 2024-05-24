package Backtracking;

import java.util.ArrayList;

public class Paranthesis {
    static ArrayList<String> al = new ArrayList<>();
    public static void generateParenthesis(int n){
        generateParenthesis(n, "", 0, 0);
    }
    private static void generateParenthesis(int n, String ans, int open, int close) {
        if (n == close) al.add(ans);
        if (open < n) {
            generateParenthesis(n, ans + "(", open + 1, close);
        }
        if(open > close){
            generateParenthesis(n, ans + ")", open, close + 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(n);
        System.out.println(al);
    }
}
