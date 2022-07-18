package com.npc.algorithms.海外码农算法.数组;

import com.npc.algorithms.backup.util.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 *
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 *
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 */
public class FindAllNumbersDisappearedInAnArray {
    @Test
    public void testfindDisappearedNumbers() {
        int[] array = {4,3,2,7,8,2,3,1};
        Util.pL(findDisappearedNumbersWithBoolMap(array));

        System.out.println();
        int[] array2 = {1,1};
        Util.pL(findDisappearedNumbersWithBoolMap(array2));;
    }

    public List<Integer> findDisappearedNumbersWithBoolMap(int[] nums) {
        List<Integer> result = new ArrayList<>();

        boolean[] boolMap = new boolean[nums.length];
        for (int i= 0;  i<nums.length ; i++) {
            boolMap[nums[i] - 1] = true;
        }

        for (int i = 1; i < boolMap.length; i++) {
            if (!boolMap[i]) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
