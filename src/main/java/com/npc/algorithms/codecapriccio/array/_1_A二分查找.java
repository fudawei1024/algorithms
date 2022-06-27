package com.npc.algorithms.codecapriccio.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author fudawei
 * @date 2022年06月22日 10:35
 * @desc
 */
public class _1_A二分查找 {

    @Test
    public void testSearch() {
        int[] nums = {1,5,6,8,18,33,78,211};
        System.out.println(search(nums, 211));
        Assert.assertEquals(0, search(nums, 1));
        Assert.assertEquals(1, search(nums, 5));
        Assert.assertEquals(2, search(nums, 6));
        Assert.assertEquals(3, search(nums, 8));
        Assert.assertEquals(4, search(nums, 18));
        Assert.assertEquals(5, search(nums, 33));
        Assert.assertEquals(6, search(nums, 78));
        Assert.assertEquals(7, search(nums, 211));
        Assert.assertEquals(-1, search(nums, 199));
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
        return -1;
    }
}
