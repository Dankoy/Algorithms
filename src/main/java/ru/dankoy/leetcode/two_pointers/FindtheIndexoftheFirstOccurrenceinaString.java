package ru.dankoy.leetcode.two_pointers;

/**
 * 28. Find the Index of the First Occurrence in a String
 * Solved
 * Easy
 * Topics
 * premium lock iconCompanies
 * 
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * 
 * Example 2:
 * 
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 * 
 * 
 */
public class FindtheIndexoftheFirstOccurrenceinaString {

    public int strStr(String haystack, String needle) {

        var result = -1;

        var chars = haystack.toCharArray();
        var needleEndIndex = needle.length();
        var needleStart = needle.toCharArray()[0];

        if (needle.length() > haystack.length()) {
            return result;
        }

        for (int i = 0; i <= chars.length - 1; i++) {

            var currentElement = chars[i];

            if (currentElement == needleStart && haystack.substring(i).length() >= needle.length()) {

                var substr = haystack.substring(i, i + needleEndIndex);

                if (substr.equals(needle)) {
                    return i;
                }

            }

        }

        return result;

    }

}
