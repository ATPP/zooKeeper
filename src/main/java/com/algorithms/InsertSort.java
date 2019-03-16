package com.algorithms;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {12, 2, 13, 4, 5, 26, 70, 12, 133, 14, 16, 137, 18, 223, 45, 627, 68, 738, 23, 45, 2};
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("－－－");
        sort(array);
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];//要插入的值
            int index = i - 1;//前一个位置
            while (index >= 0 && value < arr[index]) {
                //如果值比前一个位置小，前一个位置后移
                arr[index + 1] = arr[index];
                //index前移一位
                index--;
            }
            arr[index + 1] = value;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
