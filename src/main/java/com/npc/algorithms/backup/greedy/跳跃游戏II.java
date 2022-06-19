package com.npc.algorithms.backup.greedy;

import com.npc.algorithms.backup.util.Util;

public class 跳跃游戏II {
    public static void main(String[] args) {
        Util.p(new 跳跃游戏II().canJump2(new int[]{2,3,1,1,4}));

    }

    public int canJump(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int ans = 0;
        int curInstance = 0;
        int nextInstance = 0;
        for (int i = 0; i < nums.length - 1; i++) {
           curInstance = nums[i] + i;
           nextInstance = nums[i + 1] + (i + 1);
           if (curInstance < nextInstance) {
               ans ++;
               if (nextInstance == nums.length - 1) {
                   return ++ans;
               }
           } else {
               if (curInstance == nums.length - 1) {
                   return ++ans;
               }
           }
        }
        return ans;
    }

    public int canJump2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int ans = 0;
        int curInstance = 0;
        int maxInstance = 0;
        for (int i = 0; i < nums.length; i++) {
            maxInstance = Math.max(maxInstance, nums[i] + i);
            if (maxInstance >= nums.length - 1) {
                ans ++;
                break;
            }

            if (i == curInstance) {
                curInstance = maxInstance;
                ans ++;
            }
        }
        return ans;
    }
}

