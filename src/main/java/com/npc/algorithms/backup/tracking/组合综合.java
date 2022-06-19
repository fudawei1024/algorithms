package com.npc.algorithms.backup.tracking;

import com.npc.algorithms.backup.util.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合综合 {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        result.clear();
        backtracking(result, new LinkedList<>(), new int[]{1,2,3,4,5,6} , 4,0, 0);
        Util.p(result);
    }

    public static void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int[] candidates, int target, int startIndex, int sum) {
       if (sum > target) {
           return;
       }

        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(result, path, candidates, target, i, sum);
            sum -= candidates[i];
            path.removeLast();

        }
    }
}
