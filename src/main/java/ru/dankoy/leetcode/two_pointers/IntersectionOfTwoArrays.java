package ru.dankoy.leetcode.two_pointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * Easy
 * 
 * Given two integer arrays nums1 and nums2, return an array of their . Each
 * element in the result must be unique and you may return the result in any
 * order.
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * Example 2:
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * 
 * 
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

        int[] nums1 = new int[] { 4, 9, 5 };
        int[] nums2 = new int[] { 9, 4, 9, 8, 4 };

        intersection(nums1, nums2);

    }

    private static int[] intersection(int[] nums1, int[] nums2) {

        // result
        Set<Integer> res = new HashSet<>();

        // sort arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // use two pointers for two arrays to find intersection

        int nums1Index = 0;
        int nums2Index = 0;

        while (nums2Index < nums2.length && nums1Index < nums1.length) {

            int nums1Int = nums1[nums1Index];
            int nums2Int = nums2[nums2Index];

            if (nums1Int == nums2Int) {
                res.add(nums1Int);
                nums1Index++;
                nums2Index++;
            } else if (nums1Int > nums2Int) {
                nums2Index++;
            } else {
                nums1Index++;
            }
        }

        int[] res2 = new int[res.size()];

        Iterator<Integer> iterator = res.iterator();

        int i = 0;
        while (iterator.hasNext()) {
            res2[i] = iterator.next();
            i++;
        }

        return res2;

    }

}
