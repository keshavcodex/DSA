package SlidingWindow;

import java.lang.reflect.Array;
import java.util.*;

public class anagram {

    static void getAnagram(String input, String sentence) {
        int k = input.length();

        for (int i = 0, j = k; j <= sentence.length(); i++, j++) {
            boolean match = compareString(input, sentence.substring(i, j));
            if (match) System.out.println("start at " + i);
        }
    }

    static boolean compareString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        s1 = new String(s1Array);
        s2 = new String(s2Array);
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        String input = "aaba";
        String sentence = "aabaabaa";
        getAnagram(input, sentence);
    }
}
