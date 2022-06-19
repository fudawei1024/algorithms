package com.npc.algorithms.backup.tree;

import com.npc.algorithms.backup.util.TreeOperation;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最小深度 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
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
        int depth = 0;
        if (root == null) {
            return depth;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            depth++;
            while (size > 0) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right!= null) {
                    que.offer(node.right);
                }
                if (node.left == null && node.right == null) {
                   return depth;
                }
                size--;
            }
        }
        return depth;
    }

}
