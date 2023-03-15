package com.npc.algorithms.算法练习.溯源;

import com.npc.algorithms.util.Util;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 **
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _3_A_电话号码的字母组合 {
    StringBuilder temp = new StringBuilder();
    List<String> result = new ArrayList<>();

    static String[] numString = {"","","abc","def","ghi", "jkl", "mno","pqrs","tuv", "wxyz"};


    public List<String> combination(String digits) {
        //combiner(digits, );
        return result;
    }
    @Test
    public void testCombine() {

    }

    private void combiner(String digits, int startIndex) {
        if (startIndex == digits.length()) {
            result.add(temp.toString());
            return ;
        }
        
        String str = numString[digits.charAt(startIndex) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            combiner(digits, startIndex + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
