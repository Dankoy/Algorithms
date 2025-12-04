package ru.dankoy.leetcode.two_pointers;

import java.util.Arrays;

/**
 * 189. Rotate Array
 * Solved
 * Medium
 * Topics
 * premium lock iconCompanies
 * Hint
 * 
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * 
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * 
 */
public class ReverseArray {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };

        reverse(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void reverse(int[] arr) {

        int l = 0;
        int r = arr.length - 1;

        while (l != r) {

            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            l++;
            r--;

        }

    }

    private static int[] rotate(int[] nums, int k) {

        if (nums.length == 1 || nums.length == 0) {
            return nums;
        }

        for (int kk = 0; kk < k; kk++) {

            int remember = nums[nums.length - 1];

            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = remember;

        }

        return nums;

    }

}
