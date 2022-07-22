package com.npc.algorithms.backup.tracking;

import com.npc.algorithms.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
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
public class 子集II {
    static List<List<Integer>> lists = new ArrayList<>();
    static LinkedList<Integer> deque = new LinkedList<>();
    static boolean[] used;
    public static void main(String[] args) {
        Util.p(subsetsWithDup(new int[]{1,2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        lists.clear();
        deque.clear();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, 0);
        return lists;
    }

    public static void backtracking(int[] nums, int startIndex) {
        lists.add(new ArrayList<>(deque));

        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            deque.add(nums[i]);
            used[i] = true;
            backtracking(nums,  i + 1);
            deque.removeLast();
            used[i] = false;
        }
    }
}
