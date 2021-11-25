package com.npc.algorithms.tree;

import com.npc.algorithms.util.TreeOperation;

import java.util.List;

public class 二叉树的最大深度递归 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.left.left.right = new TreeNode(3);
        treeNode.left.left.left.right.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);

        TreeOperation.show(treeNode);

        System.out.println(depMax(treeNode));
    }


    private static int depMax(TreeNode root) {
        if (root == null) return 0;
        int leftDep = depMax(root.left);
        int rightDep = depMax(root.right);
        return Math.max(leftDep , rightDep) + 1;
    }
}
