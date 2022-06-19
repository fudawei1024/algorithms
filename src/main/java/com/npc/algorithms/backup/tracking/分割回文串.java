package com.npc.algorithms.backup.tracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 分割回文串 {

    static List<List<String>> lists = new ArrayList<>();
    static LinkedList<String> deque = new LinkedList<>();
    public static void main(String[] args) {

    }

    public static void backtracking(String str, int startIndex) {

        if (startIndex >= str.length()) {
            lists.addAll(new ArrayList(deque));
            return;
        }

        for (int i = startIndex; i < str.length(); i++) {
            if (isPalindrome(str, startIndex,i)) {
                String tmp = str.substring(startIndex, i + 1);
                deque.add(tmp);
            } else {
                continue;
            }
            //起始位置后移，保证不重复
            backtracking(str, i + 1);
            deque.removeLast();
        }
    }

    public static boolean isPalindrome(String str, int start, int end) {
        if (str == null || str.length() == 0) return false;
        if (str.length() == 1) return true;

        for (int i = start, j = end; i < j; i ++, j--) {
            if (str.charAt(start) != str.charAt(end)) return false;
        }
        return true;
    }
}
