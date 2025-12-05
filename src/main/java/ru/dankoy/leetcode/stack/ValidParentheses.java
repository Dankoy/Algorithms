package ru.dankoy.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 20. Valid Parentheses
 * Solved
 * Easy
 * Topics
 * premium lock iconCompanies
 * Hint
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "()"
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: s = "()[]{}"
 * 
 * Output: true
 * 
 * Example 3:
 * 
 * Input: s = "(]"
 * 
 * Output: false
 * 
 * Example 4:
 * 
 * Input: s = "([])"
 * 
 * Output: true
 * 
 * Example 5:
 * 
 * Input: s = "([)]"
 * 
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 * 
 * 
 * 
 */
public class ValidParentheses {

    public static void main(String[] args) {

        var s = "]";

        var isValid = isValid(s);

        System.out.println(isValid);

    }

    private static boolean isValid(String s) {

        boolean isValid = true;

        char[] chars = s.toCharArray();

        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");

        Deque<Character> deque = new ArrayDeque<>(chars.length);

        for (int i = 0; i <= chars.length - 1; i++) {

            var ch = chars[i];

            var str = String.valueOf(ch);

            if (str.equals("(") || str.equals("{") || str.equals("[")) {
                deque.push(ch);
            } else if (deque.peek() != null && deque.peek().toString().equals(map.get(str))) {
                deque.pop();
            } else {
                return false;
            }

        }

        if (!deque.isEmpty()) {
            return false;
        }

        return isValid;
    }

}
