package ru.dankoy.leetcode.array_string;

/**
 * 151. Reverse Words in a String
 * Medium
 * Topics
 * premium lock iconCompanies
 * 
 * Given an input string s, reverse the order of the words.
 * 
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * 
 * Return a string of the words in reverse order concatenated by a single space.
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces between
 * two words. The returned string should only have a single space separating the
 * words. Do not include any extra spaces.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * 
 * Example 2:
 * 
 * Input: s = " hello world "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 * 
 * Example 3:
 * 
 * Input: s = "a good example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single
 * space in the reversed string.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces '
 * '.
 * There is at least one word in s.
 * 
 */
public class ReverseWordsinaString {

    public static void main(String[] args) {

        var r = reverse("a good   example");

        System.out.println(r);

    }

    private static String reverseWords(String str) {

        String[] words = str.split("\\s");

        StringBuilder sb = new StringBuilder();

        for (String s : words) {

            sb.append(new StringBuilder(s).reverse())
                    .append(" ");

        }

        return sb.toString();

    }

    private static String reverse(String str) {

        String[] words = str.trim().split("\\s");

        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {

            var word = words[i].trim();

            if (!word.isEmpty() || !word.isBlank()) {
                sb.append(word);
                if (i != 0) {
                    sb.append(" ");
                }
            }

        }

        return sb.toString();

    }
}
