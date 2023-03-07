package Graph;

import java.util.ArrayList;

public class Practice {
    static void permutation(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String startString = p.substring(0, i);
            String endString = p.substring(i);
            permutation(startString + ch + endString, up.substring(1));
        }
    }
    static ArrayList<String> permutationsList(String p, String up) {
        if(up.isEmpty()){
            ArrayList<String> al = new ArrayList<>();
            al.add(p);
            return al;
        }
        ArrayList<String> al = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String initial = p.substring(0, i);
            String end = p.substring(i);
            al.addAll(permutationsList(initial+ch+end, up.substring(1)));
        }
        return al;
    }
    public static void main(String[] args) {
        String s = "";
        int a = Integer.valueOf(s);
//        permutation("", s);
        System.out.println(permutationsList("", s));
    }
}
