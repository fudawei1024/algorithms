package com.npc.algorithms;

/**
 * @projectName: algorithms
 * @package: com.npc.algorithms
 * @className: Search
 * @author: fudawei
 * @description: TODO
 * @date: 2021/11/9 17:01
 * @version: 1.0
 */
public class Search {

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9,10};

        for (int i=1;i< data.length + 1; i++) {
            System.out.println(new Search().search(data, i));
        }
    }

    public static int search(int[] array, int target) {
        if (array == null) {
            return -1;
        }

        if (array.length == 1) {
            return 0;
        }

        int left = 0;
        int right = array.length;

        while (left < right) {

            int mid = left + ((right - left) >> 1);

            if (array[mid] > target) {
                right = mid;
            } else if (array[mid] < target ){
                left = mid + 1;
            } else {
                return mid;
            }
            //System.out.println(String.format("left:%s   right:%s", left, right));
        }

        return -1;
    }


//    public int search(int[] data, int target) {
//        if (data == null) {
//            return -1;
//        }
//
//        int left = 0,right = data.length - 1;
//        while (left <= right) {
//            int mid = (left + right) >> 1;
//            if (data[mid] == target) {
//                return mid;
//            } else if (data[mid] > target) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return -1;
//    }
}
