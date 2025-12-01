package ru.dankoy.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * Solved
 * Easy
 * Topics
 * premium lock iconCompanies
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "egg", t = "add"
 * 
 * Output: true
 * 
 * Explanation:
 * 
 * The strings s and t can be made identical by:
 * 
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 * 
 * Example 2:
 * 
 * Input: s = "foo", t = "bar"
 * 
 * Output: false
 * 
 * Explanation:
 * 
 * The strings s and t can not be made identical as 'o' needs to be mapped to
 * both 'a' and 'r'.
 * 
 * Example 3:
 * 
 * Input: s = "paper", t = "title"
 * 
 * Output: true
 * 
 */
public class IsomorphicString {

    public static void main(String[] args) {

        String s = "badc";
        String t = "baba";

        var r = isIsomorphic(s, t);

        System.out.println(r);

    }

    public static boolean isIsomorphic(String s, String t) {

        Map<String, String> sMap = new HashMap<>();

        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        if (arrS.length != arrT.length) {
            return false;
        }

        for (int i = 0; i < arrS.length; i++) {

            String s1 = String.valueOf(arrS[i]);
            String t1 = String.valueOf(arrT[i]);

            if (!sMap.values().contains(t1)) {
                sMap.put(s1, t1);
            }

        }

        for (int i = 0; i < arrS.length; i++) {

            String t1 = String.valueOf(arrT[i]);
            String t11 = sMap.get(String.valueOf(arrS[i]));

            if (!t1.equals(t11)) {
                return false;
            }

        }

        return true;

    }

}
