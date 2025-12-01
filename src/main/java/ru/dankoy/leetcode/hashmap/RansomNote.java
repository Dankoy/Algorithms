package ru.dankoy.leetcode.hashmap;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * 383. Ransom Note
 * Solved
 * Easy
 * Topics
 * 
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * 
 * Example 2:
 * 
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * 
 * Example 3:
 * 
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * 
 */
public class RansomNote {

    public static void main(String[] args) {

        String ransomNote = "bg";
        String magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";

        boolean result = canConstruct(ransomNote, magazine);

        System.out.println(result);

    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        boolean result = true;

        Map<Character, Long> countCharsFromMagazine = magazine.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        Map<Character, Long> countCharsFromNote = ransomNote.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        for (Map.Entry<Character, Long> entry : countCharsFromNote.entrySet()) {

            // "aa"
            Character charr = entry.getKey();
            Long count = entry.getValue();

            Long countInMagazine = countCharsFromMagazine.get(charr);

            if (countInMagazine == null || (count > countInMagazine)) {
                result = false;
                return result;
            }
        }

        return result;

    }

}
