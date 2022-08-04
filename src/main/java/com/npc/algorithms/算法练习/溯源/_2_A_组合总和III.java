package com.npc.algorithms.算法练习.溯源;

import com.npc.algorithms.util.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的每个数字在每个组合中只能使用 一次 。

 注意：解集不能包含重复的组合。 

  

 示例 1:

 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 输出:
 [
 [1,1,6],
 [1,2,5],
 [1,7],
 [2,6]
 ]
 示例 2:

 输入: candidates = [2,5,2,1,2], target = 5,
 输出:
 [
 [1,2,2],
 [5]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/combination-sum-ii
 */
public class _2_A_组合总和III {
    int sum = 0;
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> sumList = new LinkedList<>();


    public List<List<Integer>> combinationSum3(int k, int n) {
        combiner(n, k, 1, 0);
        return result;
    }
    @Test
    public void testCombine() {
        combinationSum3(3, 7);
        Util.p(result);
    }

    private void combiner(int tarSum, int k, int startIndex, int sum) {
       if (sum > tarSum) return;
       if (sumList.size() == k) {
           if (tarSum == sum) {
               result.add(new ArrayList<>(sumList));
           }
           return;
       }

        for (int i = startIndex; i <= 9 - (k - sumList.size()) + 1; i++) {
            sum += i;
            sumList.add(i);
            combiner(tarSum, k, i + 1, sum);
            sumList.removeLast();
            sum -= i;
        }
    }
}
