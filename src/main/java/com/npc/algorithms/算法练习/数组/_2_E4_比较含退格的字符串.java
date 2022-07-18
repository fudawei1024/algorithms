package com.npc.algorithms.算法练习.数组;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 示例 1：
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 *
 * 示例 2：
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 *
 * 示例 3：
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 *
 * 提示：
 * 1 <= s.length, t.length <= 200
 * s 和 t 只含有小写字母以及字符 '#'
 *
 * 进阶：
 * 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 */
public class _2_E4_比较含退格的字符串 {

    @Test
    public void test() {
        Assert.assertTrue(backspaceCompare("ab#c","ad#c"));
        Assert.assertTrue(backspaceCompare("ab##","c#d#"));
        Assert.assertTrue(!backspaceCompare("a#c","b"));


        Assert.assertTrue(backspaceCompare2("ab#c","ad#c"));
        Assert.assertTrue(backspaceCompare2("ab##","c#d#"));
        Assert.assertTrue(!backspaceCompare2("a#c","b"));
    }

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >=0 || j >=0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0){
                    skipS --;
                    i --;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0){
                    skipT --;
                    j --;
                } else {
                    break;
                }
            }

            if (i >=0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else if (i >=0 || j >= 0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    private String build(String s) {
        StringBuffer ret = new StringBuffer();

        for (char c: s.toCharArray()) {
            if (c != '#') {
                ret.append(c);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }
}
