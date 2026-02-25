package ru.dankoy.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 * Solved
 * Medium
 * Topics
 * premium lock iconCompanies
 * Hint
 * 
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the ith
 * interval and intervals is sorted in ascending order by starti. You are also
 * given an interval newInterval = [start, end] that represents the start and
 * end of another interval.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in
 * ascending order by starti and intervals still does not have any overlapping
 * intervals (merge overlapping intervals if necessary).
 * 
 * Return intervals after the insertion.
 * 
 * Note that you don't need to modify intervals in-place. You can make a new
 * array and return it.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * Example 2:
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * 
 * 
 * 
 * Constraints:
 * 
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 * 
 * 
 */
public class InsertInterval {

    public static void main(String[] args) {

        int[][] intervals = new int[][] { { 1, 2 }, { 3, 5 }, { 8, 10 }, { 12, 16 } };

        int[] newInterval = new int[] { 6, 7 };

        var res = insert(intervals, newInterval);

        System.out.println(res);

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        // intervals = [[1,2],[3,5],[8,10],[12,16]],
        // newInterval = [6,7]
        for (int i = 0; i < intervals.length; i++) {

            int[] currentInterval = intervals[i];

            int cS = currentInterval[0];
            int cE = currentInterval[1];

            // if newInterval before slot insert newInterval & update slot as new interval
            if (newInterval[1] < cS) {
                result.add(newInterval);
                newInterval = currentInterval;
            }

            // if slot is lesser than new Interval insert slot
            else if (cE < newInterval[0]) {
                result.add(currentInterval);
            }

            // if above conditions fail its an overlap since possibility of new interval
            // existing in left & right of slot is checked
            // update lowest of start & highest of end & not insert
            else {
                newInterval[0] = Math.min(newInterval[0], cS);
                newInterval[1] = Math.max(newInterval[1], cE);
            }

        }

        // insert the last newInterval
        result.add(newInterval);

        // convert result to array
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;

    }

}
