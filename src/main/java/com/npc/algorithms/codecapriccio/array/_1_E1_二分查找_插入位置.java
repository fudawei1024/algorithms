package com.npc.algorithms.codecapriccio.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author fudawei
 * @date 2022年06月22日 10:35
 * @desc
 *
 * 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 */
public class _1_E1_二分查找_插入位置 {

    @Test
    public void testSearch() {
        int[] nums = {1,3,5,6};
        Assert.assertEquals(2, search(nums, 5));
        Assert.assertEquals(1, search(nums, 2));
        Assert.assertEquals(4, search(nums, 7));
        Assert.assertEquals(4, search(nums, 8));
        Assert.assertEquals(0, search(nums, 0));
        Assert.assertEquals(0, search(nums, 1));
    }

    private int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }
}
