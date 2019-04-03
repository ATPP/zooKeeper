package com.algorithms.leetCode;

import sun.security.util.Length;

import java.util.Arrays;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] array = {1, 2};
        int[] array1 = {3, 4};
        System.out.println(solution(array, array1));
    }

    public static double solution(int[] nums1, int[] nums2) {
        //数组扩容
        int[] result = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
        int resultLength = result.length;
        if (resultLength % 2 == 1) {
            return result[resultLength / 2];
        } else {
            return (double) (result[resultLength / 2 - 1] + result[resultLength / 2]) / 2;
        }
    }
}
