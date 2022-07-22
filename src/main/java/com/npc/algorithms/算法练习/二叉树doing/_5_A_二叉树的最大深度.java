package com.npc.algorithms.算法练习.二叉树doing;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 *给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree
 */
public class _5_A_二叉树的最大深度 {

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
        return Math.max(maxDepth(root.left, depth), maxDepth(root.right, depth));
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
