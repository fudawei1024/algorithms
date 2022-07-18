package com.npc.algorithms.算法练习.数组;

import com.npc.algorithms.backup.util.Util;
import org.junit.Test;

/**
 * @author fudawei
 * @date 2022年07月11日 23:27
 * @desc
 */
public class _2_E3_移动零 {

    @Test
    public void test() {
        int[] nums = {0,1,0,3,12};
        Util.p(nums);
        moveZeroes(nums);
        Util.p(nums);
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int left = 0,right=0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
            right++;
        }
        while (left < right) {
            nums[left++] = 0;
        }
    }
}
