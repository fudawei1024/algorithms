package com.npc.algorithms.backup.tracking;

import com.npc.algorithms.util.Util;

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
public class 全排列II {
    static List<List<Integer>> lists = new ArrayList<>();
    static LinkedList<Integer> deque = new LinkedList<>();
    static boolean[] used;

    public static void main(String[] args) {
        Util.p(subsetsWithDup(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        lists.clear();
        deque.clear();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        used = new boolean[nums.length];
        backtracking(nums);
        return lists;
    }

    public static void backtracking(int[] nums) {
        if (deque.size()  == nums.length) {
            lists.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            deque.add(nums[i]);
            backtracking(nums);
            deque.removeLast();
            used[i] = false;
        }
    }
}
