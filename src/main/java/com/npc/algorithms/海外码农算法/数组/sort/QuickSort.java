package com.npc.algorithms.海外码农算法.数组.sort;

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
        System.out.println(new Random().nextInt(arr.length - 1));
    }

    public static void quickSort(int[] arr){
        System.out.println(Arrays.toString(arr));
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (arr == null) {
            return ;
        }
        if (left < right) {
            //swap(arr, (left + (int)(Math.random() * (right - left + 1))), right);
            int[] tmpArr = partition2(arr, left, right);
            quickSort(arr, left, tmpArr[0] - 1);
            quickSort(arr, tmpArr[1] + 1, right);
        }
    }

    private static void quickSort2(int[] arr, int left, int right) {
        if (arr == null) {
            return ;
        }

        if (left < right) {
            swap(arr, (left + (int)(Math.random() * (right - left + 1))), right);
            int[] par = partition2(arr, left, right);
            quickSort2(arr, left, par[0] - 1);
            quickSort2(arr, par[1] + 1, right);
        }
    }

//    private static int partition(int[] arr, int left, int right) {
//        int pivot = arr[left];
//        while (left < right) {
//            while (left < right && arr[right] >= pivot) {
//                right --;
//            }
//            arr[left] = arr[right];
//
//            while (left < right && arr[left] <= pivot) {
//                left ++;
//            }
//            arr[right] = arr[left];
//        }
//        arr[left] = pivot;
//        return left;
//    }

    private static int[] partition2(int[] arr, int left, int right) {
        int key = arr[right];
        int current = left;

        int small = left - 1;
        int big = right;

        while (current < big) {
            if (arr[current] < key) {
                swap(arr, ++ small, current ++);
            } else if (arr[current] > key) {
                swap(arr, current, --big);
            } else {
                current ++;
            }
        }

        swap(arr, right, big);
        return new int[]{small + 1, big};
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}


