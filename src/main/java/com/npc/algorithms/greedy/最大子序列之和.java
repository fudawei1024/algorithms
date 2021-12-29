package com.npc.algorithms.greedy;

import com.npc.algorithms.util.Util;

public class 最大子序列之和 {
    public static void main(String[] args) {
        Util.p(new 最大子序列之和().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) {
                result = count;
            }

            if (count <= 0) {
                count = 0;
            }
        }
        return result;
    }
}
