package com.npc.algorithms.backup.tracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 复原IP地址 {


    static List<String> lists = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        lists.clear();
        backtracking(s, 0, 0);
        return lists;
    }

    public void backtracking(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                lists.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum ++;
                backtracking(s, i + 2, pointNum);
                pointNum --;
                s = s.substring(0, i + 1) +  s.substring(i + 1);
            } else {
                break;
            }
        }
    }

    // 判断字符串s在左闭又闭区间[start, end]所组成的数字是否合法
    static Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到非数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果大于255了不合法
                return false;
            }
        }
        return true;
    }
}
