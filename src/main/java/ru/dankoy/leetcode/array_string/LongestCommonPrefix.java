package ru.dankoy.leetcode.array_string;

import java.util.Arrays;

/**
 * 14. Longest Common Prefix
 * Solved
 * Easy
 * Topics
 * premium lock iconCompanies
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * Example 2:
 * 
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters if it is non-empty.
 * 
 * 
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

    }

    public static String longestCommonPrefix(String[] strs) {

        char[] result = new char[200];
        var firstString = strs[0];

        if (strs.length == 0 || firstString.length() == 0) {
            return "";
        }

        // sort by word length (biggest first)

        Arrays.sort(strs);

        var sp = 0;

        var left = strs[0];
        var right = strs[strs.length - 1];

        while (sp <= left.length() - 1 && sp <= right.length() - 1) {

            // take first char and assume it is valid
            char le = left.toCharArray()[sp];
            char re = right.toCharArray()[sp];

            if (le == re) {

                result[sp] = le;

            } else {
                return String.valueOf(Arrays.copyOf(result, sp));
            }

            sp++;

        }

        char[] result2 = Arrays.copyOf(result, sp);

        return String.valueOf(result2);

    }
}
