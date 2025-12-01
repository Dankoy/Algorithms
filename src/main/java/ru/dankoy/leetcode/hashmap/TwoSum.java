package ru.dankoy.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Solved
 * Easy
 * 
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2:
 * 
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Example 3:
 * 
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;

        var res = twoSum(nums, target);

    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(); // val, idx

        for (int i = 0; i < nums.length; i++) {

            int curr = nums[i];
            int diff = target - curr;

            if (map.containsKey(diff)) {
                return new int[] { i, map.get(diff) };
            }
            map.put(curr, i);

        }
        return new int[] {};

    }

}
