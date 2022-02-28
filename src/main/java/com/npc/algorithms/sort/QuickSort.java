package com.npc.algorithms.sort;

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
        quickSort(new int[]{4, 8, 2, 7, 6, 0, 1});
    }

    public static void quickSort(int[] arr){
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left,int right){
        int middle;
        if(left < right){
            middle = partition(arr,left,right);
            quickSort(arr, left,middle - 1);
            quickSort(arr,middle+1, right);
        }
    }

    public static int partition(int[] arr,int left,int right){
        int pivot = arr[left];
        System.out.println(String.format("pivot:%s  left:%s right:%s", pivot, left, right));
        while(left < right){
            while(left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            System.out.println(Arrays.toString(arr) + " left:" + left + " right:" + right);
            while(left < right && arr[left]<= pivot) {
                left++;
            }
            arr[right] = arr[left];
            System.out.println(Arrays.toString(arr) + " left:" + left + " right:" + right);
        }
        arr[left] = pivot;
        return left;
    }
}


