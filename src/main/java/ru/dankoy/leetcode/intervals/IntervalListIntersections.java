package ru.dankoy.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 986. Interval List Intersections
 * Solved
 * Medium
 * 
 * You are given two lists of closed intervals, firstList and secondList, where
 * firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list
 * of intervals is pairwise disjoint and in sorted order.
 * 
 * Return the intersection of these two interval lists.
 * 
 * A closed interval [a, b] (with a <= b) denotes the set of real numbers x with
 * a <= x <= b.
 * 
 * The intersection of two closed intervals is a set of real numbers that are
 * either empty or represented as a closed interval. For example, the
 * intersection of [1, 3] and [2, 4] is [2, 3].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList =
 * [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 
 * Example 2:
 * 
 * Input: firstList = [[1,3],[5,9]], secondList = []
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 0 <= firstList.length, secondList.length <= 1000
 * firstList.length + secondList.length >= 1
 * 0 <= starti < endi <= 109
 * endi < starti+1
 * 0 <= startj < endj <= 109
 * endj < startj+1
 * 
 * 
 */
public class IntervalListIntersections {

    public static void main(String[] args) {

        // int[][] a = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        // int[][] b = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

        // int[][] a = { { 5, 10 } };
        // int[][] b = { { 5, 10 } };

        int[][] a = { { 3, 10 } };
        int[][] b = { { 5, 10 } };

        // int[][] a = { { 8, 15 } };
        // int[][] b = { { 2, 6 }, { 8, 10 }, { 12, 20 } };

        int[][] res = intervalIntersection(a, b);

        Arrays.stream(res)
                .forEach(h -> System.out.println(Arrays.toString(h)));

    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int point1 = 0;
        int point2 = 0;

        List<int[]> result = new ArrayList<>();

        while (point1 < firstList.length && point2 < secondList.length) {

            if (secondList.length == 0 || firstList.length == 0) {
                return convert(result);
            }

            int[] intersection = new int[2];

            int low = Math.max(firstList[point1][0], secondList[point2][0]);
            int high = Math.min(firstList[point1][1], secondList[point2][1]);

            if (low <= high) {
                intersection[0] = low;
                intersection[1] = high;
                result.add(intersection);
            }

            if (firstList[point1][1] < secondList[point2][1]) {
                point1++;
            } else {
                point2++;
            }

        }

        return convert(result);
    }

    private static int[][] convert(List<int[]> list) {
        int[][] arrayres = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            arrayres[i] = list.get(i);
        }
        return arrayres;
    }

}
