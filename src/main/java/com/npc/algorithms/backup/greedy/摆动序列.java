package com.npc.algorithms.backup.greedy;


import com.npc.algorithms.util.Util;

public class 摆动序列 {
    public static void main(String[] args) {
        int c = new 摆动序列().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8});
        Util.p(c);
    }
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int preDiff = 0;
        int curDiff = 0;
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                result ++;
                preDiff = curDiff;
            }
        }
        return result;
    }
}
