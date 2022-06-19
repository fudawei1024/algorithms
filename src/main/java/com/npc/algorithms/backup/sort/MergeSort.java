package com.npc.algorithms.backup.sort;

import java.util.Arrays;

/**
 * @className: QuikSort
 * @author: fudawei
 * @description: TODO
 * @date: 2022/2/28 15:19
 * @version: 1.0
 */


public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 8, 2,6, 7, 6, 0,2, 1};
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
    }

    public static int[] sort(int[] array,int low,int high, int[] temp ){
        int mid = (low+high) / 2;
        if(low < high){
            sort(array, low, mid, temp);
            sort(array,mid + 1, high, temp);
            //左右归并
            merge(array, low, mid, high, temp);
        }
        return array;
    }

    public static void merge(int[] arr,int low,int mid,int high,int[] tmp){
        int i = 0;
        int j = low,k = mid + 1;  //左边序列和右边序列起始索引
        while(j <= mid && k <= high){
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }

        while (k <= high) {
            tmp[i++] = arr[k++];
        }

        for(int t = 0; t < i; t++) {
            arr[low + t] = tmp[t];
        }
    }
}


