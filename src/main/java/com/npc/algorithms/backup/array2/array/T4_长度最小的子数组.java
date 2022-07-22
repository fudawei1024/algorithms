package com.npc.algorithms.backup.array2.array;

import com.npc.algorithms.util.Util;

/**
 * @className: T4_长度最小的子数组
 * @author: fudawei
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 联系一下 ： https://leetcode-cn.com/problems/fruit-into-baskets/
 *           https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @date: 2022/2/10 20:04
 * @version: 1.0
 */
public class T4_长度最小的子数组 {
    public static void main(String[] args) {
        int[] array = new int[]{2,2,1,3,4,3};
        Util.p(minSubArrayLen(array, 10));
    }

    private static int minSubArrayLen(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(right - left + 1, result);
                sum -= nums[left ++];
            }
        }
        return result < Integer.MAX_VALUE ? result : 0;
    }



//    private static int minSubArrayLen(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int result = Integer.MAX_VALUE;
//        int left = 0;
//        int sum = 0;
//        for (int right = 0; right < nums.length; right++) {
//            sum += nums[right++];
//            while (sum >= left) {
//                result = Math.min(result, right - left + 1);
//                sum -= nums[left];
//            }
//        }
//        return result == Integer.MAX_VALUE ? 0 : result;
//    }
}
