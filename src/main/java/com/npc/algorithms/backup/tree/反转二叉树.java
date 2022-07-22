package com.npc.algorithms.backup.tree;

import com.npc.algorithms.util.TreeOperation;


public class 反转二叉树 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);

        TreeOperation.show(treeNode);
        System.out.println();

        invertTreeLast(treeNode);
        TreeOperation.show(treeNode);

    }

    private static void invertTreeFirst(TreeNode treeNode) {
        if (treeNode == null) {
            return ;
        }

        TreeNode tmpNode = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = tmpNode;
        invertTreeFirst(treeNode.left);
        invertTreeFirst(treeNode.right);
    }

    private static void invertTreeMid(TreeNode treeNode) {
        if (treeNode == null) {
            return ;
        }
        invertTreeMid(treeNode.left);
        TreeNode tmpNode = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = tmpNode;
        invertTreeMid(treeNode.right);
    }

    private static void invertTreeLast(TreeNode treeNode) {
        if (treeNode == null) {
            return ;
        }
        invertTreeLast(treeNode.left);
        invertTreeLast(treeNode.right);
        TreeNode tmpNode = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = tmpNode;
    }
}
