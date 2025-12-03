package ru.dankoy.leetcode.two_pointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        var res = maxArea(height);

        System.out.println(res);

    }

    public static int maxArea(int[] height) {

        int resultVolume = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            int l = height[left];
            int r = height[right];

            int smallest = l <= r ? l : r;

            int rangeInBetween = right - left;

            int currentVolume = smallest * rangeInBetween;

            resultVolume = resultVolume < currentVolume ? currentVolume : resultVolume;

            if (l == smallest) {
                left++;
            } else {
                right--;
            }

        }

        return resultVolume;

    }
}
