package com.npc.algorithms.算法学习.sort;

import com.npc.algorithms.util.Util;

import java.util.Arrays;
import java.util.Random;

/**
 * @className: QuikSort
 * @author: fudawei
 * @description: TODO
 * @date: 2022/2/28 15:19
 * @version: 1.0
 */


public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 3, 6, 7, 1, 0, 2, 5};
        quickSort(arr);
        Util.p(arr);
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = part(arr, low, high);
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, high);
        }
    }

    private static int part(int[] arr, int low, int high) {
        int left = low - 1, current = low, key = arr[high];

        while (current <= high) {
            if (arr[current] <= key) {
                swap(arr, current ++ , ++ left);
            } else {
                current ++;
            }
        }
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}


