package com.npc.algorithms.codecapriccio.array;

import com.npc.algorithms.backup.util.Util;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组[4,3]是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 * 进阶：
 *
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 *
 * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
 */
public class _4_A_长度最小的子数组 {

    @Test
    public void test() {
        int[] tree = {2,3,1,2,4,3};
        Assert.assertEquals(2, totalFruit(tree));
    }

    public int totalFruit(int[] tree) {
        int ans = 0, left = 0, right = 0;
        Counter counter = new Counter();
        while (right < tree.length) {
            counter.add(tree[right], 1);
            if (counter.size() > 2) {
                counter.add(tree[left], -1);
                if (counter.get(tree[left]) == 0) {
                     counter.remove(tree[left]);
                     left++;
                }
            }

            ans = Math.max(ans, right++ - left + 1);
        }
        return ans;
    }
}

class Counter extends HashMap<Integer, Integer> {
    public Integer get(Integer k) {
        return containsKey(k) ? super.get(k) : 0;
    }

    public void add(Integer k, Integer v) {
        put(k, get(k) + v);
    }
}
