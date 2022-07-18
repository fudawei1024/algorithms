package com.npc.algorithms.海外码农算法.数组;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only
 * number in the range that is missing from the array.
 *
 * Example 1:
 * Input: nums = [3,0,1]
 * Output: 2
 *
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 *
 *  Example 2:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 *
 * Example 3:
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * All the numbers of nums are unique.
 *
 *
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
public class MissingNumber {

    @Test
    public void testMissingNumber() {
        int[] array = {0, 1, 2, 3, 4, 6};
        int[] array2 = {0, 1, 2, 3, 4, 5, 6, 8};
        int[] array3 = {0, 1, 3, 4, 5, 6, 7, 8};

        Assert.assertTrue( 5 == findMissingNumber2(array));
        Assert.assertTrue( 7 == findMissingNumber2(array2));
        Assert.assertTrue( 2 == findMissingNumber2(array3));

        Assert.assertTrue( 5 == findMissingNumber(array));
        Assert.assertTrue( 7 == findMissingNumber(array2));
        Assert.assertTrue( 2 == findMissingNumber(array3));

        Assert.assertTrue( 5 == findMissingNumberXOR(array));
        Assert.assertTrue( 7 == findMissingNumberXOR(array2));
        Assert.assertTrue( 2 == findMissingNumberXOR(array3));
    }

    private static int findMissingNumber(int[] array) {
        if (array == null || array.length <= 0) {
            return -1;
        }

        int arraySum = 0;
        for (int i = 0; i < array.length; i++) {
            arraySum += array[i];
        }

        int length = array.length + 1;
        int result = (length - 1) * length / 2 - arraySum;

        if (result == 0) {
            result = length;
        }
        return result;
    }

    private static int findMissingNumber2(int[] array) {
        int result = -1;

        if (array == null || array.length <= 0) {
            return result;
        }

        boolean[] map = new boolean[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            map[array[i]] = true;
        }

        for (int i = 0; i < map.length; i++) {
            if (!map[i]) {
                result = i;
                break;
            }
        }
        return result;
    }

    private static int findMissingNumberXOR(int[] array) {
        int result = 0;

        for (int i = 0; i < array.length + 1; i++) {
            result  = result ^ i;
        }

        for (int i = 0; i < array.length; i++) {
            result = array[i] ^ i;
        }

        return result;
    }
}
