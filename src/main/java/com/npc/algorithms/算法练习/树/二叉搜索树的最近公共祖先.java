package com.npc.algorithms.算法练习.树;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;

public class 二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeOperation.show(root);
        System.out.println();
        TreeNode result = lowestCommonAncestor(root, root.left.left, root.left.right);
        if (result == null) {
            System.out.println(result.value);
        } else {
            System.out.println("empty");
        }
        TreeOperation.show(result);

    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if (root == null || root == p || root == q ) {
           return root;
        }

       TreeNode left = lowestCommonAncestor(root.left, p, q);
       TreeNode right = lowestCommonAncestor(root.right, p, q);

       if (left == null && right == null) {
           return null;
       } else if (left != null && right == null) {
           return left;
       }  else if (left == null && right != null) {
            return right;
        } else {
           return root;
       }
    }
}
