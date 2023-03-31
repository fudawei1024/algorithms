package com.npc.algorithms.算法学习.sort;

import com.npc.algorithms.util.Util;

/**
 * @className: QuikSort
 * @author: fudawei
 * @description: TODO
 * @date: 2022/2/28 15:19
 * @version: 1.0
 */


public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 5, 2,7,4,8,9,4};

        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
        Util.p(array);
    }

    private static void sort(int[] array, int low, int high, int[] temp) {
        if (low < high) {
            int mid = low + ((high - low) >> 2);
            sort(array, low, mid, temp);
            sort(array, mid + 1, high, temp);
            merge(array, low, mid, high, temp);
        }
    }

    private static void merge(int[] array, int low, int mid, int high, int[] temp) {
        int index = 0, left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            temp[index++] = array[left] > array[right] ? array[right++] : array[left ++];
        }

        while (left <= mid) {
            temp[index++] = array[left ++];
        }

        while (right <= high) {
            temp[index++] = array[right ++];
        }

        for (int i = 0; i < index; i++) {
            array[low + i] = temp[i];
        }
    }
}


