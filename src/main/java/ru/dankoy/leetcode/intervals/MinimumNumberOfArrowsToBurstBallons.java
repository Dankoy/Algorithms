package ru.dankoy.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * Solved
 * Medium
 * Topics
 * 
 * There are some spherical balloons taped onto a flat wall that represents the
 * XY-plane. The balloons are represented as a 2D integer array points where
 * points[i] = [xstart, xend] denotes a balloon whose horizontal diameter
 * stretches between xstart and xend. You do not know the exact y-coordinates of
 * the balloons.
 * 
 * Arrows can be shot up directly vertically (in the positive y-direction) from
 * different points along the x-axis. A balloon with xstart and xend is burst by
 * an arrow shot at x if xstart <= x <= xend. There is no limit to the number of
 * arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting
 * any balloons in its path.
 * 
 * Given the array points, return the minimum number of arrows that must be shot
 * to burst all balloons.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 * 
 * Example 2:
 * 
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4
 * arrows.
 * 
 * Example 3:
 * 
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
 * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= points.length <= 105
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 * 
 * 
 */
public class MinimumNumberOfArrowsToBurstBallons {

    public static void main(String[] args) {

        int[][] points =
                // new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
                // new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
                new int[][] { { 3, 9 }, { 7, 12 }, { 3, 8 }, { 6, 8 }, { 9, 10 }, { 2, 9 }, { 0, 9 }, { 3, 9 },
                        { 0, 6 }, { 2, 8 } };

        int res = findMinArrowShots(points);
        System.out.println(res);

    }

    public static int findMinArrowShots(int[][] points) {

        int arrows = 0;

        // sort by start
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int currentIndex = 0;

        boolean end = false;

        while (currentIndex <= points.length - 1) {

            int[] point = points[currentIndex];

            int currStart = point[0];
            int currStop = point[1];

            arrows++;

            int nextIndex = currentIndex + 1;

            if (nextIndex >= points.length) {
                end = true;
            }

            for (int i = nextIndex; i < points.length; i++) {

                int[] nextPoint = points[i];

                int nextStart = nextPoint[0];
                int nextStop = nextPoint[1];

                if (nextStart > currStop) {
                    currentIndex = i;
                    break;
                } else if (i == points.length - 1) {
                    currentIndex = points.length - 1;
                    end = true;
                }

            }

            if (end) {
                break;
            }

        }

        return arrows;

    }

}
