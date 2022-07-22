package com.npc.algorithms.backup.tree;

import com.npc.algorithms.util.TreeOperation;

import java.util.Deque;
import java.util.LinkedList;


public class 对称二叉树 {
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
        System.out.println(isSymmetric2(treeNode));

        TreeNode treeNode2 = new TreeNode(10);
        treeNode2.left = new TreeNode(6);
        treeNode2.right = new TreeNode(6);
        treeNode2.left.left = new TreeNode(3);
        treeNode2.left.left.left = new TreeNode(4);
        treeNode2.left.left.right = new TreeNode(2);
        treeNode2.left.right = new TreeNode(9);
        treeNode2.right.left = new TreeNode(9);
        treeNode2.right.right = new TreeNode(3);
        treeNode2.right.right.right = new TreeNode(4);
        treeNode2.right.right.left = new TreeNode(2);

        TreeOperation.show(treeNode2);
        System.out.println();

        System.out.println(isSymmetric2(treeNode2));

    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }
    private static boolean compare(TreeNode left, TreeNode right) {

        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val) return false;

        return compare(left.left, right.right) && compare(left.right, right.left);
    }

    /**
     * 迭代法
     * 使用双端队列，相当于两个栈
     */
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> deque = new LinkedList<>();
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
