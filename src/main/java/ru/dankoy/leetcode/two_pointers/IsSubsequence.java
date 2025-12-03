package ru.dankoy.leetcode.two_pointers;

/**
 * 392. Is Subsequence
 * Solved
 * Easy
 * Topics
 * 
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise.
 * 
 * A subsequence of a string is a new string that is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * 
 * Example 2:
 * 
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * 
 */
public class IsSubsequence {

    public static void main(String[] args) {

        String s = "abc", t = "ahbgdc";

        System.out.println(isSubsequence(s, t));

    }

    public static boolean isSubsequence(String s, String t) {

        var result = false;

        var arrayString = t.toCharArray();
        var arraySubString = s.toCharArray();

        var idxString = 0;
        var idxSubString = 0;

        if (t.equals(s)) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        } else if (s.isEmpty()) {
            return true;
        }

        for (int i = 0; i < arrayString.length; i++) {

            var substringChar = arraySubString[idxSubString];
            var stringChar = arrayString[i];

            if (substringChar == stringChar) {
                idxSubString++;
            }

            if (idxSubString >= arraySubString.length) {
                return true;
            }

        }

        return result;

    }
}
