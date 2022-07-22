package com.npc.algorithms.算法练习.哈希表_doing;

import org.junit.Assert;
import org.junit.Test;

/**
 *给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 * 提示：
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ransom-note
 * */
public class _2_E1_赎金信 {
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
