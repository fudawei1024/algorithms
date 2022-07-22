package com.npc.algorithms.backup.greedy;

import com.npc.algorithms.util.Util;

public class 跳跃游戏 {
    public static void main(String[] args) {
        Util.p(new 跳跃游戏().canJump(new int[]{2,3,1,1,4}));
        Util.p(new 跳跃游戏().canJump(new int[]{3,2,1,0,4}));

    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i < nums.length; i++) {
            cover = Math.max(i + nums[i], cover);
            if (cover == nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

