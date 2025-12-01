package ru.dankoy.leetcode.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 290. Word Pattern
 * Solved
 * Easy
 * 
 * Given a pattern and a string s, find if s follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in s. Specifically:
 * 
 * Each letter in pattern maps to exactly one unique word in s.
 * Each unique word in s maps to exactly one letter in pattern.
 * No two letters map to the same word, and no two words map to the same letter.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: pattern = "abba", s = "dog cat cat dog"
 * 
 * Output: true
 * 
 * Explanation:
 * 
 * The bijection can be established as:
 * 
 * 'a' maps to "dog".
 * 'b' maps to "cat".
 * 
 * Example 2:
 * 
 * Input: pattern = "abba", s = "dog cat cat fish"
 * 
 * Output: false
 * 
 * Example 3:
 * 
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * 
 * Output: false
 * 
 * 
 */
public class WordPattern {

    public static void main(String[] args) {

        String pattern = "abba";
        String s = "dog cat cat dog";

        var b = wordPattern(pattern, s);
        System.out.println(b);

    }

    public static boolean wordPattern(String pattern, String s) {

        char[] patternChars = pattern.toCharArray();
        List<String> words = Arrays.asList(s.trim().split(" "));
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        if (patternChars.length != words.size()) {
            return false;
        }

        for (int i = 0; i < patternChars.length; i++) {

            Character ch = Character.valueOf(patternChars[i]);
            String word = words.get(i);

            map.putIfAbsent(ch, word);
            map2.putIfAbsent(word, ch);

        }

        if (map.size() != map2.size()) {
            return false;
        }

        for (int i = 0; i < patternChars.length; i++) {

            Character curr = Character.valueOf(patternChars[i]);
            String currWord = map.get(curr);
            String actualWord = words.get(i);

            if (!currWord.equals(actualWord)) {
                return false;
            }

        }

        return true;

    }

}
