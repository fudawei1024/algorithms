package com.npc.algorithms.海外码农算法.数组;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class ContainsDuplicate {

    @Test
    public void testContainsDuplicate() {
        int[] array = {1, 2, 3, 4, 5, 5, 6};
        Assert.assertTrue(containsDuplicateWithSort(array));

        int[] array2 = {1, 2, 3, 4, 5, 6};
        Assert.assertTrue(!containsDuplicateWithSort(array2));

        Assert.assertTrue(containsDuplicateWithIntSet(array));
        Assert.assertTrue(!containsDuplicateWithIntSet(array2));
    }

    private static boolean containsDuplicateWithSort(int[] array) {
        if (array == null || array.length <= 0) {
            return false;
        }

        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                return true;
            }
        }

        return false;
    }



    private static boolean containsDuplicateWithIntSet(int[] array) {
        Set<Integer> intSet = new HashSet<>();
        if (array == null || array.length <= 0) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
           if (intSet.contains(array[i])) {
               return true;
           } else {
               intSet.add(array[i]);
           }
        }
        return false;
    }
}
