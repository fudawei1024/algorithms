package com.npc.algorithms.backup.tracking;

import com.npc.algorithms.backup.util.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合总和III {

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        combie(2, 7);
        Util.p(result);
    }

    public static void combie(int k, int n) {
        backtracking(n, k, 1, 0);
    }

    public static void backtracking(int n, int k, int startIndex, int sum) {
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            sum += i;
            path.add(i);
            backtracking(n, k,  i + 1, sum);
            sum -= i;
            path.removeLast();
        }
    }


    public static List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }

    private static void backTracking(int targetSum, int k, int startIndex, int sum) {
        // 减枝
        if (sum > targetSum) {
            return;
        }

        if (path.size() == k) {
            if (sum == targetSum) result.add(new ArrayList<>(path));
            return;
        }

        // 减枝 9 - (k - path.size()) + 1
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            //回溯
            path.removeLast();
            //回溯
            sum -= i;
        }
    }
}
