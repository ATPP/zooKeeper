package com.algorithms;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {12, 2, 13, 4, 5, 26, 70, 12, 133, 14, 16, 137, 18, 223, 45, 627, 68, 738, 23, 45, 2};
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("－－－");
        bubble(array);
    }

    private static int[] bubble(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        for (int k = 0; k < arr.length - 1; k++) {
            System.out.print(arr[k] + ", ");
        }
        return arr;
    }
}
