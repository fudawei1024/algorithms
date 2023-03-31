package com.npc.algorithms.算法练习.排序;

import com.npc.algorithms.util.Util;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 8, 2,6, 7, 5, 0, 3, 1};
        sort(array);
        Util.p(array);
    }



    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        for (int i = arr.length - 1 ; i > 0; i --) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j , j+1);
                }
            }
        }
    }

    public static void swap(int[] array, int i, int  j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
