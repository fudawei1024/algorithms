package com.npc.algorithms.codecapriccio.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author fudawei
 * @date 2022年06月23日 11:28
 * @desc
 * 给你一个非负整数 x ，计算并返回x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留整数部分 ，小数部分将被舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 *
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *
 */
public class _1_E3_x的平方根 {

    @Test
    public void testRange() {
        Assert.assertEquals(2,mySqrt(5));
        Assert.assertEquals(2,mySqrt(6));
        Assert.assertEquals(3,mySqrt(9));
    }

    public int mySqrt(int x) {
        int low = 0, high = x, ans = -1;
        while (low <= high) {
            int mid = low + ((high - low) / 2 );
            if ((long) mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
