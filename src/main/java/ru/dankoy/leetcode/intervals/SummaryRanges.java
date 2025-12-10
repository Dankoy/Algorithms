package ru.dankoy.leetcode.intervals;

import java.util.LinkedList;
import java.util.List;

/**
 * 228. Summary Ranges
 * Easy
 * Topics
 * You are given a sorted unique integer array nums.
 * 
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * 
 * Return the smallest sorted list of ranges that cover all the numbers in the
 * array exactly. That is, each element of nums is covered by exactly one of the
 * ranges, and there is no integer x such that x is in one of the ranges but not
 * in nums.
 * 
 * Each range [a,b] in the list should be output as:
 * 
 * "a->b" if a != b
 * "a" if a == b
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 
 * Example 2:
 * 
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order.
 * 
 * 
 */
public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 2, 4, 5, 7 };
        // int[] nums = new int[] { 0, 2, 3, 4, 6, 8, 9 };

        var res = summaryRanges(nums);
    }

    public static List<String> summaryRanges(int[] nums) {

        List<String> result = new LinkedList<>();

        int start = 0;
        int end = 0;

        if (nums.length == 1) {
            return List.of(String.valueOf(nums[0]));
        }

        while (start < nums.length) {

            // check if last, then add to result one element
            if (end == nums.length - 1) {
                if (start == end) {
                    result.add(String.valueOf(nums[start]));
                    break;
                } else {
                    result.add(nums[start] + "->" + nums[end]);
                    break;
                }

            }
            int current = nums[end];
            int next = nums[end + 1];

            if (next == current + 1) {
                end++;
            } else if (start == end) {
                result.add(String.valueOf(nums[start]));
                start = end + 1;
                end += 1;
            } else {
                result.add(nums[start] + "->" + nums[end]);
                start = end + 1;
                end += 1;
            }

        }

        return result;
    }

}
