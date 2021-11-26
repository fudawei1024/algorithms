package com.npc.algorithms.tree;

import com.npc.algorithms.util.TreeOperation;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最小深度递归 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        //treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);
        treeNode.right.left.left = new TreeNode(14);
        treeNode.right.left.left.left = new TreeNode(14);

        TreeOperation.show(treeNode);

        System.out.println(minDepth(treeNode));
        System.out.println(minDepth(null));
    }

    private static Integer minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        if (root.right != null && root.left == null) {
            return 1 + minDepth(root.right);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

}
