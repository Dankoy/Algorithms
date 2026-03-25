package ru.dankoy.leetcode.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 49. Group Anagrams
 * Medium
 * Topics
 * premium lock iconCompanies
 * 
 * Given an array of strings strs, group the
 * 
 * together. You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * 
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Explanation:
 * 
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form
 * each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to
 * form each other.
 * 
 * Example 2:
 * 
 * Input: strs = [""]
 * 
 * Output: [[""]]
 * 
 * Example 3:
 * 
 * Input: strs = ["a"]
 * 
 * Output: [["a"]]
 * 
 * 
 */
public class GroupAnagram {

    public static void main(String[] args) {

        String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };

        var res = groupAnagrams2(strs);

        System.out.println(res);

    }

    /**
     * Use sorting mechanism t0 find anagrams
     * 
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            var sortedWord = String.valueOf(chars);

            map.computeIfPresent(sortedWord, (s, l) -> {
                l.add(str);
                return l;
            }); // add word to list

            map.computeIfAbsent(sortedWord, s -> {
                var list = new ArrayList<String>();
                list.add(str);
                return list;
            }); // add new list

        }

        return map.values().stream().toList();

    }

    /**
     * Time limit exceeded, but works fine
     * 
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        // result
        List<List<String>> result = new ArrayList<>();

        // already processed words
        Set<String> alreadyProcessed = new HashSet<>();

        // Empty string is anagram to empty string. Magic as is.

        for (int i = 0; i < strs.length; i++) {

            var currWord = strs[i];

            if (!alreadyProcessed.contains(currWord)) {
                alreadyProcessed.add(currWord);
            } else {
                continue;
            }

            List<String> currentAnagrams = new ArrayList<>();
            currentAnagrams.add(currWord);

            for (int next = i + 1; next < strs.length; next++) {

                var nextWord = strs[next];

                // if (alreadyProcessed.contains(nextWord) && !nextWord.equals(currWord)) {
                // continue;
                // }

                if (isAnagram(currWord, nextWord)) {
                    currentAnagrams.add(nextWord);
                    alreadyProcessed.add(nextWord);
                }

            }
            result.add(currentAnagrams);

        }

        return result;

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
