package com.npc.algorithms.backup.tracking;

import com.npc.algorithms.util.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 子集 {

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> deque = new LinkedList<>();
    public static void main(String[] args) {
        backtracking(new int[]{1,1,3}, 0);
        Util.p(result);
    }

    public static void backtracking(int[] arr, int startIndex) {
        result.add(new ArrayList<Integer>(deque));

        for (int i = startIndex; i < arr.length; i++) {
            deque.add(arr[i]);
            backtracking(arr, i + 1);
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
