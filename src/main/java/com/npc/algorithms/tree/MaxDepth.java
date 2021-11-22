package com.npc.algorithms.tree;

import com.npc.algorithms.util.TreeOperation;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);
        treeNode.right.left.left = new TreeNode(14);
        treeNode.right.left.left.right = new TreeNode(14);


        TreeOperation.show(treeNode);

        System.out.println(maxDepth(treeNode));
        System.out.println(maxDepth(null));

    }

    private static Integer maxDepth(TreeNode root) {
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
                size--;
            }

        }
        return depth;
    }
}
