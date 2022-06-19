package com.npc.algorithms.backup.array;

/**
 * @projectName: algorithms
 * @package: com.npc.algorithms
 * @className: RemoveElement
 * @author: fudawei
 * @description: TODO
 * @date: 2021/11/9 20:01
 * @version: 1.0
 */
public class RemoveElement {

    public static void main(String[] args) {
//        System.out.println(removeElement(new int[]{1,2,2,3,3,3,4,4,4,4}, 1));
//        System.out.println(removeElement(new int[]{1,2,2,3,3,3,4,4,4,4}, 2));
        System.out.println(removeElement(new int[]{1,2,2,3,3,3,4,4,4,4}, 3));
//        System.out.println(removeElement(new int[]{1,2,2,3,3,3,4,4,4,4}, 4));
    }

    public static int removeElement2(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
            System.out.println(slowIndex + "-" + fastIndex);
        }
        return slowIndex;
    }

    public static int removeElement(int[] num, int val) {
        if (num == null) {
            return 0;
        }
        int slow = 0;
        for (int fast=0; fast < num.length;fast ++){
            if (num[fast] != val) {
                num[slow++] = num[fast];
            }
        }
        return slow;
    }
}
