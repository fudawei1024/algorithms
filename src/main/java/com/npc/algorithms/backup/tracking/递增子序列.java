package com.npc.algorithms.backup.tracking;

import com.npc.algorithms.backup.util.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @projectName: algorithms
 * @package: com.npc.algorithms.tracking
 * @className: 子集II
 * @author: fudawei
 * @description: TODO
 * @date: 2021/12/27 19:49
 * @version: 1.0
 */
public class 递增子序列 {
    static List<List<Integer>> lists = new ArrayList<>();
    static LinkedList<Integer> deque = new LinkedList<>();

    public static void main(String[] args) {
        Util.p(subsetsWithDup(new int[]{1,2,3, 2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        lists.clear();
        deque.clear();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        backtracking(nums, 0);
        return lists;
    }

    public static void backtracking(int[] nums, int startIndex) {
        if (deque.size() > 1) {
            lists.add(new ArrayList<>(deque));
        }

        boolean[] used = new boolean[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (!deque.isEmpty() && nums[i] < deque.get(deque.size() - 1) || used[nums[i] + 100]) {
                continue;
            }
            used[nums[i] + 100] = true;
            deque.add(nums[i]);
            backtracking(nums,  i + 1);
            deque.removeLast();
        }
    }
}
