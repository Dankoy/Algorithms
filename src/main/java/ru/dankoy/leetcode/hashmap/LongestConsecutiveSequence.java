package ru.dankoy.leetcode.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * Solved
 * Medium
 * Topics
 * 
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * Example 2:
 * 
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * 
 * Example 3:
 * 
 * Input: nums = [1,0,1,2]
 * Output: 3
 * 
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = new int[] { 100, 4, 200, 1, 3, 2 };

        var res = longestConsecutive(nums);

    }

    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int result = 0;

        for (Integer i : set) {

            int prev = i - 1;

            if (!set.contains(prev)) {

                int seqLength = 1;
                boolean hasNext = true;
                int next = i;

                while (hasNext) {

                    next += 1;

                    if (set.contains(next)) {
                        seqLength += 1;
                    } else {
                        hasNext = false;
                    }

                }

                result = Math.max(result, seqLength);

            }

        }

        return result;

    }

}
