package com.npc.algorithms.backup.tree;

import com.npc.algorithms.util.TreeOperation;

public class 二叉搜索树中的搜索 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeOperation.show(root);
        System.out.println();
        TreeNode result = searchBST(root, 2);
        TreeOperation.show(result);
    }

    private static TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        TreeNode treeNode = null;
        if (root.val == target) {
            return root;
        } else if (root.val < target) {
            treeNode = searchBST(root.right, target);
        } else if (root.val > target) {
            treeNode = searchBST(root.left, target);
        }
        return treeNode;
    }
}
