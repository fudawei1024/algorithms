package com.npc.algorithms.backup.sort;

import com.npc.algorithms.util.Util;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @className: QuikSort
 * @author: fudawei
 * @description: TODO
 * @date: 2022/2/28 15:19
 * @version: 1.0
 */


public class HeapSort {

    public static void main(String[] args) {
        int[] array = Util.randomNumbers();
        Util.p(array);
        for (int i = 0; i < array.length; i++) {
            heapInsert(array, i);
        }

        int heapSize = array.length;
        swap(array, 0, --heapSize);
        while (heapSize > 0) {
            heapify(array, 0, heapSize);
            swap(array, 0, -- heapSize);
        }
        Util.p(array);
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] array, int index, int heapSize) {
        int leftChild = index * 2 + 1;

        while (leftChild < heapSize) {
            int largest = (leftChild + 1) < heapSize && array[leftChild] < array[leftChild + 1] ? leftChild + 1  : leftChild;
            largest = array[largest] > array[index] ? largest : index;

            if (largest == index) {
                break;
            }

            swap(array, largest, index);
            index = largest;
            leftChild = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}


