package com.npc.algorithms.tracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @projectName: algorithms
 * @package: com.npc.algorithms.tracking
 * @className: 组合总和III
 * @author: fudawei
 * @description: TODO
 * @date: 2021/12/20 00:57
 * @version: 1.0
 */
public class 组合总和III {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void backtracking(int k, int n, int sum, int startIndex) {
        if (path.size() == k) {
            if (sum == 0) {
                result.add(new ArrayList(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            sum -= i;
            path.push(i);
            backtracking(k, n, sum, i);
            path.removeLast();
            sum += i;
        }
    }
}
