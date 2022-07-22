package com.npc.algorithms.算法练习.哈希表_doing;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 *
 * 示例1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-anagram
 */
public class _1_A_有效的字母异位词 {
    @Test
    public void testSearch() {
        Assert.assertTrue(isAnagram("abcdefg", "gbdaefc"));
    }

    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char cs: s.toCharArray()) {
            record[cs - 'a'] += 1;
        }
        for (char ct: t.toCharArray()) {
            record[ct - 'a'] -= 1;
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
