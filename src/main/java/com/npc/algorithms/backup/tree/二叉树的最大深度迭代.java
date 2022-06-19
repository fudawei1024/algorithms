package com.npc.algorithms.backup.tree;

import com.npc.algorithms.backup.util.TreeOperation;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大深度迭代 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.left.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);

        TreeOperation.show(treeNode);

        System.out.println(depMax(treeNode));
    }


    private static int depMax(TreeNode root) {
        if (root == null) return 0;

        int deep = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            deep ++;
        }
        return deep;
    }
}
