package com.npc.algorithms.算法学习.sort;


import com.npc.algorithms.util.Util;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 8, 2, 6, 7, 5, 0, 3, 1};
        sort(array);
        Util.p(array);

        array = null;
        sort(array);
        Util.p(array);
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return ;
        }

        for (int i= 1; i < arr.length; i ++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
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
