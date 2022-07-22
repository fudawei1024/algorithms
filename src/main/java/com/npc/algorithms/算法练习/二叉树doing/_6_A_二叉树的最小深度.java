package com.npc.algorithms.算法练习.二叉树doing;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-depth-of-binary-tree
 */
public class _6_A_二叉树的最小深度 {

    @Test
    public void testSearch() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeOperation.show(root);

        Assert.assertEquals(3, maxDepth(root));
    }


    public int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        return Math.min(maxDepth(root.left, depth), maxDepth(root.right, depth));
    }

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size -- > 0) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

}
