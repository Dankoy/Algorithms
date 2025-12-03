package ru.dankoy.leetcode.two_pointers;

/**
 * 125. Valid Palindrome
 * Solved
 * Easy
 * Topics
 * premium lock iconCompanies
 * 
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * Example 2:
 * 
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * 
 * Example 3:
 * 
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric
 * characters.
 * Since an empty string reads the same forward and backward, it is a
 * palindrome.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 * 
 * 
 */
public class ValidPolindrome {

    public static void main(String[] args) {

        var s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {
        boolean result = true;

        String str = s.trim();

        str = str.replaceAll("\\s", "");
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        str = str.replaceAll("\\W", "");

        str = str.toLowerCase();

        if (str.isEmpty()) {
            return result;
        }

        char[] chars = str.toCharArray();

        int l = 0;
        int r = chars.length - 1;

        while (l <= r) {

            if (chars[l] != chars[r]) {
                result = false;
                return result;
            }

            l++;
            r--;

        }

        return result;
    }

}
