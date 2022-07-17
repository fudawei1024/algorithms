package com.npc.algorithms.codecapriccio.数组;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author fudawei
 * @date 2022年06月22日 11:45
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：你可以设计并实现时间复杂度为 $O(\log n)$ 的算法解决此问题吗？
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * #
 */
public class _1_E2_在排序数组中查找元素的第一个和最后一个位置 {
    @Test
    public void testRange() {
        int[] nums = {5,7,7,8,8,10};
        int[] range = searchRange(nums, 6);

        Assert.assertEquals(range[0], -1);
        Assert.assertEquals(range[1], -1);


        range = searchRange(nums, 7);

        Assert.assertEquals(range[0], 1);
        Assert.assertEquals(range[1], 2);


        range = searchRange(nums, 8);

        Assert.assertEquals(range[0], 3);
        Assert.assertEquals(range[1], 4);
    }

    private int[] searchRange(int[] nums, int target) {

        int index = search(nums, target);

        if (index == -1) {
            return new int[]{-1, -1};
        }

        int left = index,right = index;

        while (nums[left - 1] == target && left - 1 > 0) {
            left --;
        }

        while (right + 1 < nums.length - 1 && nums[right + 1] == target) {
            right ++;
        }
        return new int[]{left, right};
    }


    public int search(int[] nums, int target) {
        int low = 0,high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low ) / 2;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
