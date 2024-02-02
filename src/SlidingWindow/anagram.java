package SlidingWindow;

import java.lang.reflect.Array;
import java.util.*;

public class anagram {
    public static String[] generatePermutations(String str) {
        List<String> result = new ArrayList<>();
        generateHelper(str.toCharArray(), 0, result);
        return result.toArray(new String[0]);
    }

    private static void generateHelper(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            generateHelper(chars, index + 1, result);
            swap(chars, index, i); // Backtrack
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void anagram(String longStr, String shortStr) {
        if (longStr.length() < shortStr.length()) {
            anagram(shortStr, longStr);
        }
        int lastStart = 0;
        for (int i = 0; i < longStr.length(); i++) {
            int index = longStr.indexOf(shortStr, lastStart);
            if (index != -1) {
                System.out.println("start from index " + index);
                lastStart = index + 1;
            }
        }
    }

    public static void main(String[] args) {
        String input = "aaba";
        String sentence = "aabaabaa";
        String[] permutations = generatePermutations(input);
        for(String str: permutations){
            anagram(str, sentence);
        }
    }
}
