package udemy.backtracking;

public class FindSubset {
    public static void main(String[] args) {
        String s = "abc";
        subset("", s);
    }

    static void subset(String output, String str) {
        if (str.isEmpty()) {
            System.out.println(output);
            return;
        }
        char ch = str.charAt(0);
        subset(output, str.substring(1));
        subset(output + ch, str.substring(1));
    }
}

