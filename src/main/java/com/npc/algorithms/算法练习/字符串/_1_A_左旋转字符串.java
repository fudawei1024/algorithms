package com.npc.algorithms.算法练习.字符串;

import org.junit.Assert;
import org.junit.Test;

/**
 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

 示例 1：

 输入: s = "abcdefg", k = 2
 输出:"cdefgab"
 示例 2：

 输入: s = "lrloseumgh", k = 6
 输出:"umghlrlose"

 限制：

 1 <= k < s.length <= 10000

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 */
public class _1_A_左旋转字符串 {
    @Test
    public void testSearch() {
        StringBuilder builder = new StringBuilder("12345678");

        System.out.println(reverseLeftWords("12345678", 3));

    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder(s);
        reverse(builder, 0 , n - 1);
        reverse(builder, n, s.length() - 1);
        reverse(builder, 0, s.length() - 1);
        return builder.toString();
    }

    public void reverse(StringBuilder builder, int left, int right) {
        while (left < right) {
            char leftS = builder.charAt(left);
            builder.setCharAt(left ++, builder.charAt(right));
            builder.setCharAt(right --, leftS);
        }
    }
}
