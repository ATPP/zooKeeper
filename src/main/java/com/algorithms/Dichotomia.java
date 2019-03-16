package com.algorithms;

import java.util.Arrays;

/**
 * 二分法
 */
public class Dichotomia {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 12, 13, 14, 16, 17, 18, 23, 45, 67, 68, 78};
        int mid = biSearch(array, 67);
        System.out.println(mid);
    }

    private static int biSearch(int[] array, int a) {
        int start = 0;
        int end = array.length - 1;
        int mid;
        Arrays.sort(array);
        while (start <= end) {
            //中间位置
            mid = (start + end) / 2;
            if (array[mid] == a) {
                return mid + 1;
            } else if (array[mid] < a) { //to right
                start = mid + 1;
            } else { //to left
                end = mid - 1;
            }
        }
        return -1;
    }

}
