package com.npc.algorithms.backup.array2.array;

/**
 * @projectName: algorithms
 * @package: com.npc.algorithms
 * @className: RemoveElement
 * @author: fudawei
 * @description: 二分查找
 * @date: 2021/11/9 20:01
 * @version: 1.0
 */
public class T1_二分查找 {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        for (int i = 1; i <= array.length; i++) {
            //System.out.println(i);
            System.out.println(search(array, i));
        }
    }

    public static int search(int[] array, int target) {
        if (array == null) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                return mid + 1;
            }
        }
        return -1;
    }
}
