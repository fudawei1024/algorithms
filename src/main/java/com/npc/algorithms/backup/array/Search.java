package com.npc.algorithms.backup.array;

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

        System.out.println(new Search().search(null, 5));
        System.out.println(new Search().search(data, 10));
    }

    public int search(int[] data, int target) {
        if (data == null) {
            return -1;
        }

        int left = 0,right = data.length - 1;
        while (left <= right) {
            int mid = ((right + left) >> 1);
            System.out.println(String.format("left:%s  right:%s  mid:%s", left, right, mid));
            if (data[mid] == target) {
                System.out.println(String.format("left:%s  right:%s  mid:%s", left, right, mid));
                return mid;
            } else if (data[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
