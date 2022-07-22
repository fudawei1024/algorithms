package com.npc.algorithms.算法练习.二叉树;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/symmetric-tree
 */
public class _4_A_对称二叉树 {

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
        Assert.assertTrue(!isSymmetric2(root));

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(7);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(1);
        TreeOperation.show(root2);
        Assert.assertTrue(isSymmetric2(root2));
    }


    public Boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public Boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }

        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }


    public Boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) return true;
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            deque.offerFirst(left.left);
            deque.offerFirst(left.right);
            deque.offerLast(right.right);
            deque.offerLast(right.left);
        }
        return true;
    }
}
