package recursion;

import java.util.ArrayList;
import java.util.List;

public class createAllAnagram {
    static List<String> anagrams = new ArrayList<>();

    public static void main(String[] args) {
        String s = "abc";
        createAnagrams(s, "");
        System.out.println();
        System.out.println(anagrams);
    }

    private static void createAnagrams(String s, String current) {
        if (s.isEmpty()) {
            System.out.print(current + ", ");
            anagrams.add(current);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            String remaining = s.substring(0, i) + s.substring(i + 1);
            createAnagrams(remaining, current + ch);
        }
    }
}
