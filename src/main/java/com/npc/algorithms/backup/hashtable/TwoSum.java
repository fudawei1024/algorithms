package com.npc.algorithms.backup.hashtable;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        while(index < nums.length - 1) {
            int tmp = target - nums[index];
            if (map.containsKey(tmp)) {
                return new int[]{index, map.get(tmp)};
            }
            map.put(nums[index], index++);
        }
        return new int[0];
    }
}
