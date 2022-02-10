package com.npc.algorithms.greedy;

import com.npc.algorithms.util.Util;

public class 买卖股票的最佳时机II {
    public static void main(String[] args) {
        Util.p(new 买卖股票的最佳时机II().maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            result += Math.max(nums[i] - nums[i -1], 0);
        }
        return result;
    }
}
