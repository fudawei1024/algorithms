package com.npc.algorithms.backup.sort;

import java.util.Arrays;

/**
 * @className: QuikSort
 * @author: fudawei
 * @description: TODO
 * @date: 2022/2/28 15:19
 * @version: 1.0
 */


public class QuickSort {
    public static void main(String[] args) {
        quickSort(new int[]{4, 8, 2,6, 7, 6, 0,2, 1});
    }

    public static void quickSort(int[] arr){
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (arr == null) {
            return ;
        }
        if (left < right) {
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right --;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] <= pivot) {
                left ++;
            }
            arr[right] = arr[left];

        }
        arr[left] = pivot;
        return left;
    }


    private static int partition2(int[] arr, int left, int right) {
        int midIndex = left + ((right - left) >> 1);
        int pivot = arr[midIndex];
        while (left < right) {
            while (left < right && arr[right] > pivot) {
                right --;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] < pivot) {
                left ++;
            }
            arr[right] = arr[left];

        }
        arr[left] = pivot;
        return left;
    }


}


