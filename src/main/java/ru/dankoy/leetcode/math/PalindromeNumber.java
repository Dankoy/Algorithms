package ru.dankoy.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 9. Palindrome Number
 * Solved
 * Easy
 * Topics
 * 
 * Given an integer x, return true if x is a
 * 
 * , and false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * 
 * Example 2:
 * 
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 * 
 * Example 3:
 * 
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * 
 * 
 * 
 * Constraints:
 * 
 * -231 <= x <= 231 - 1
 * 
 * 
 */
public class PalindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalindrome(121));

    }

    private static boolean isPalindrome(int x) {

        List<Integer> ints = new ArrayList<>();
        int cur = x;

        if (x < 0) {
            return false;
        }

        while (cur != 0) {
            int right = cur % 10;
            cur = cur / 10;
            ints.add(right);
        }

        int left = 0;
        int right = ints.size() - 1;

        while (left < right) {

            int l = ints.get(left);
            int r = ints.get(right);

            if (l != r) {
                return false;
            }

            left++;
            right--;

        }

        return true;
    }

}
