package ru.dankoy.leetcode.hashmap;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 242. Valid Anagram
 * Easy
 * 
 * 
 * Given two strings s and t, return true if t is an
 * 
 * of s, and false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram"
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: s = "rat", t = "car"
 * 
 * Output: false
 * 
 */
public class ValidAnagram {

    public static void main(String[] args) {

    }

    public static boolean isAnagram(String s, String t) {

        Map<Character, Long> sMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        Map<Character, Long> tMap = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        if (sMap.size() != tMap.size()) {
            return false;
        }

        for (Map.Entry<Character, Long> entry : sMap.entrySet()) {
            var k = entry.getKey();
            var v = entry.getValue();

            var tV = tMap.get(k);

            if (Objects.isNull(tV) || !tV.equals(v)) {
                return false;
            }

        }

        return true;

    }

}
