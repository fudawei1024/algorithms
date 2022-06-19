package com.npc.algorithms.backup.array2.array;

import java.util.Objects;

/**
 * @projectName: algorithms
 * @package: com.npc.algorithms.array2.array
 * @className: 移除元素
 *
 * @author: fudawei
 * @description:
 *  * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *  * 不要使用额外的数组空间，你必须仅使用 $O(1)$ 额外空间并原地修改输入数组。
 *  * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *  * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
 *  * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * @date: 2022/2/10 17:55
 * @version: 1.0
 */
public class T2_移除元素 {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1,2,3,4,4,6,7,4,9,4}, 4));
    }

    private static int removeElement(int[] nums, int ele) {
        if (nums == null) {
            return 0;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != ele) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
