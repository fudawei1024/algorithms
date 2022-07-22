package com.npc.algorithms.backup.tree;

import com.npc.algorithms.util.TreeOperation;


public class 合并二叉树 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(6);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        TreeNode treeNode2 = new TreeNode(3);

        TreeOperation.show(root1);
        System.out.println();
        TreeOperation.show(root2);
        System.out.println();

        TreeNode root = mergeTrees(root1, root2);
        TreeOperation.show(root);

    }

    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

}
