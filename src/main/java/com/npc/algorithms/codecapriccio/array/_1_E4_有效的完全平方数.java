package com.npc.algorithms.codecapriccio.array;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 *
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 *
 *
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 *
 * 提示：
 * 1 <= num <= 2^31 - 1
 */
public class _1_E4_有效的完全平方数 {

    @Test
    public void testRange() {
        Assert.assertEquals(false, isPerfectSquare(5));
        Assert.assertEquals(true, isPerfectSquare(100));
        Assert.assertEquals(true, isPerfectSquare(9));
        Assert.assertEquals(true, isPerfectSquare(10000));

    }

    public boolean isPerfectSquare(int x) {
        int low = 0, high = x, ans = -1;
        while (low <= high) {
            int mid = low + ((high - low) / 2 );
            if ((long) mid * mid < x) {
                low = mid + 1;
            } else if ((long) mid * mid > x) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
