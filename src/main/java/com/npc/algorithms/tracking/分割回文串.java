package com.npc.algorithms.tracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 分割回文串 {

    List<List<String>> lists = new ArrayList<>();
    LinkedList<String> deque = new LinkedList<>();
    public static void main(String[] args) {

    }

    public static boolean backtracking(String str, int startIndex) {
        if (isPalindrome(str, startIndex,0)) {

        } else {

        }
        return Boolean.TRUE;
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
