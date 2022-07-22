package com.npc.algorithms.backup.tree;

import com.npc.algorithms.util.TreeOperation;

public class 完全二叉树的节点个数 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);
        treeNode.right.left.right = new TreeNode(14);
        treeNode.right.left.right.left = new TreeNode(14);

        TreeOperation.show(treeNode);

        System.out.println(getNodesNum(treeNode));
        System.out.println(getNodesNum(null));
    }

    private static int getNodesNum(TreeNode root) {
        if (root == null) {return 0;}

        return getNodesNum(root.left) + getNodesNum(root.right) + 1;
    }

}
