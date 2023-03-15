package com.npc.algorithms.backup.sort;

import com.npc.algorithms.util.Util;

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
        int[] array = new int[]{1, 3, 4, 5, 2,7,4,8,9,4};
        sort2(array, 0, array.length - 1);
        Util.p(array);
    }

    public static void sort2(int[] array, int low, int high) {
        if (low == high) {
            return;
        }

        int mid = low + ((high - low) >> 1);

        if (low < high) {
            sort2(array, low, mid);
            sort2(array, mid + 1, high);
            merge2(array, low,  mid, high);
        }
    }


    private static void merge2(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int pl = low,pr = mid + 1;
        int index = 0;
        while (pl <= mid && pr <= high) {
            temp[index ++] = array[pl] < array[pr] ?  array[pl ++] : array[pr ++];
        }

        while (pl <= mid) {
            temp[index ++] =  array[pl ++];
        }

        while (pr <= high) {
            temp[index ++] =  array[pr ++];
        }

        for (int i = 0; i < index; i++) {
            array[low + i] = temp[i];
        }
    }


    public static int[] sort(int[] array,int low,int high, int[] temp ){
        int mid = low + ((high - low) >> 1);
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
            tmp[i++] = (arr[j] > arr[k] ? arr[k++] : arr[j++]);
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


