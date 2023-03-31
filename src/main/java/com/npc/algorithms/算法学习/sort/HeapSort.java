package com.npc.algorithms.算法学习.sort;

import com.npc.algorithms.util.Util;

/**
 * @className: QuikSort
 * @author: fudawei
 * @description: 堆排序
 * @date: 2022/2/28 15:19
 * @version: 1.0
 */


public class HeapSort {

    public static void main(String[] args) {

        int[] array = Util.randomNumbers();
        Util.p(array);
        for (int i = 0; i < array.length; i++) {
            heapInsæert(array, i);
        }
        Util.p(array);

        int heapSize = array.length;
        swap(array, 0, --heapSize);

        Util.p(array);
        while (heapSize > 0) {
            heapify(array, 0, heapSize);
            swap(array, 0, --heapSize);
           // Util.p(array);
        }

        Util.p(array);
    }

    private static void heapify(int[] array, int index, int heapSize) {
        int leftChild = index * 2 + 1;
        while (leftChild < heapSize) {
            int rightChild = leftChild + 1;
            int largest = rightChild < heapSize && array[leftChild] < array[rightChild] ?  rightChild : leftChild;

            largest = array[index] > array[largest] ? index : largest;

            if (largest == index) {
                break;
            }
            swap(array, index, largest);
            index = largest;
            leftChild = index * 2 + 1;
        }
    }

    private static void heapInsæert(int[] array, int index) {
        while (array[index] > array[(index - 1) / 2]) {
            swap(array, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}


