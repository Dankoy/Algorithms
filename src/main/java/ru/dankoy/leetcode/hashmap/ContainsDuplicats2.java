package ru.dankoy.leetcode.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. Contains Duplicate II
 * Solved
 * Easy
 * Topics
 * premium lock iconCompanies
 * 
 * Given an integer array nums and an integer k, return true if there are two
 * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i
 * - j) <= k.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * Example 2:
 * 
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * Example 3:
 * 
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * 
 */
public class ContainsDuplicats2 {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 1, 2, 3 };
        int k = 2;

        var res = containsNearbyDuplicate(nums, k);
        System.out.println(res);

    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {

        int i = 0;
        Set<Integer> window = new HashSet<>();

        while (i < nums.length) {

            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
            i++;
        }

        return false;
    }

}
