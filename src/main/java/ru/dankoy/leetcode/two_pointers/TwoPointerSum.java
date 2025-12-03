package ru.dankoy.leetcode.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointerSum {

    public static void main(String[] args) {

        int[] arr = { 2, 4, 6, 8, 10 };
        int sum = 14;

        List<int[]> result = sum(arr, sum);

        result.stream()
                .forEach(array -> System.out.println(Arrays.toString(array)));

    }

    private static List<int[]> sum(int[] array, int sum) {

        Arrays.sort(array);

        List<int[]> result = new ArrayList<>();

        var pointer1 = 0;
        var pointer2 = array.length - 1;

        while (pointer1 < pointer2) {

            var a = array[pointer1] + array[pointer2];

            if (a == sum) {

                int[] res = { array[pointer1], array[pointer2] };
                result.add(res);

                pointer1++;
                pointer2--;

            } else if (a < sum) {
                pointer1++;
            } else {
                pointer2--;
            }

        }

        return result;

    }

}
