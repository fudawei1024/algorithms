package com.npc.algorithms.backup.array;

public class MinSubArrayLen {


    public static void main(String[] args) {
        System.out.println(minSubArrayLen(new int[]{1,2,2,3,3,3,4,4,4,4}, 10));
        System.out.println(minSubArrayLen2(new int[]{1,2,2,3,3,3,4,4,4,4}, 10));

    }


    public static int minSubArrayLen(int[] array, int s) {
        if (array == null) return 0;

        int left=0, sum=0;
        int result = Integer.MAX_VALUE;
        for (int fast=0; fast<array.length; fast++) {
            sum += array[fast];
            while (sum >= s) {
                result = Math.min(result, fast - left + 1);
                sum -= array[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    public static int minSubArrayLen2(int[] nums, int s) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
