package ru.dankoy.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 * Solved
 * Medium
 * 
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * 
 * Example 2:
 * 
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * Example 3:
 * 
 * Input: intervals = [[4,7],[1,4]]
 * Output: [[1,7]]
 * Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * 
 * 
 */
public class MergeIntervals {

    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals) {

        int amountOfIntervals = intervals.length;

        List<int[]> result = new ArrayList<>();

        // sort by start
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int currentIndex = 0;

        // merge
        while (currentIndex < amountOfIntervals) {

            int[] merged = new int[2];

            int[] current = intervals[currentIndex];

            for (int i = currentIndex + 1; i < amountOfIntervals; i++) {
                int[] next = intervals[i];

                if (next[0] <= current[1]) {
                    merged[0] = current[0];

                    if (next[1] <= current[1]) {
                        merged[1] = current[1];
                    } else {
                        merged[1] = next[1];
                    }

                    current = merged;
                    currentIndex++;
                }
            }

            result.add(current);

            currentIndex++;
        }

        // convert result to array
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;

    }

}
