package com.npc.algorithms.backtracking;

import com.npc.algorithms.util.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @projectName: algorithms
 * @package: com.npc.algorithms.backtracking
 * @className: 组合
 * @author: fudawei
 * @description: TODO
 * @date: 2021/12/13 19:55
 * @version: 1.0
 */
public class 组合 {
    public static void main(String[] args) {
        组合 组合实例 = new 组合();
        List<List<Integer>> result = 组合实例.combine(5,3);
        Util.p(result);
    }

    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        combinehelper(n,k, 1);
        return result;
    }

    public void combinehelper(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i ++) {
            path.add(i);
            combinehelper(n, k, i + 1);
            path.removeLast();
        }
    }
}
