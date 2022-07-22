package com.npc.algorithms.算法练习.数组;

import com.npc.algorithms.util.Util;
import org.junit.Test;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *
 * 进阶：
 *
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 *
 * 链接：https://leetcode.cn/problems/squares-of-a-sorted-array
 */
public class _3_A_有序数组的平方 {

    @Test
    public void test() {
        int[] nums = {-4,-1,0,3,10};
        Util.p(sortedSquares(nums));
    }

    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] ret = new int[nums.length];

        int i = 0, j = nums.length - 1;
        int index = j;
        while (i < j) {
            int sqrLeft = nums[i] * nums[i];
            int sqrRight = nums[j] * nums[j];
            if (sqrLeft > sqrRight) {
                ret[index --] = sqrLeft;
                i ++;
            } else {
                ret[index --] = sqrRight;
                j --;
            }
        }
        return ret;
    }
}
