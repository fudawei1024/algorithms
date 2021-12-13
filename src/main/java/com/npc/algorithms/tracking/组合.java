package com.npc.algorithms.tracking;

import com.npc.algorithms.util.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合 {

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        backtracking(5, 3, 1);
        Util.p(result);
    }

    public static void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k,  i + 1);
            path.removeLast();
        }
    }
}
