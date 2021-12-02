package com.npc.algorithms.tree;

import com.npc.algorithms.util.TreeOperation;

public class 路径总和迭代 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);
        treeNode.right.left.right = new TreeNode(14);
        treeNode.right.left.right.left = new TreeNode(14);

        TreeOperation.show(treeNode);

        System.out.println(traversal(treeNode, 16));
        System.out.println(traversal(treeNode, 45));
        System.out.println(traversal(treeNode, 68));
    }

    private static boolean traversal(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }
        return traversal(root.left, sum - root.val) || traversal(root.right, sum - root.val);
    }
}
