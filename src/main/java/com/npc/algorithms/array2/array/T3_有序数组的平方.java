package com.npc.algorithms.array2.array;

import com.npc.algorithms.util.Util;

/**
 * @className: 有序数组的平方
 * @author: fudawei
 * @description:
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 示例 1： 输入：nums = [-4,-1,0,3,10] 输出：[0,1,9,16,100] 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 * 示例 2： 输入：nums = [-7,-3,2,3,11] 输出：[4,9,9,49,121]
 *
 *
 * @date: 2022/2/10 20:04
 * @version: 1.0
 */
public class T3_有序数组的平方 {

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
        Util.p(sqr(nums));
    }

    public static int[] sqr(int[] nums) {
        int[] result = new int[nums.length];
        int left=0,right=nums.length - 1;
        int  index = nums.length - 1;
        while (left < right) {
            int lq = nums[left] * nums[left];
            int rq = nums[right] * nums[right];
            if (lq > rq) {
                result[index --] = lq;
                left ++;
            } else {
                result[index --] = rq;
                right --;
            }
        }
        return result;
    }
}
