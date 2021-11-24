package com.npc.algorithms.tree;

import com.npc.algorithms.util.TreeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);

        TreeOperation.show(treeNode);

        TreeNode result = connect(treeNode);

       TreeOperation.show(treeNode);
    }

    private static TreeNode connect(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();

            TreeNode pre = null;
            int count = 0;
            while (size > 0) {
                count++;
                TreeNode node = que.poll();

                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
                if (count == 1) {
                        pre = node;
                } else {
                    pre.next = node;
                    pre = pre.next;
                }
                size --;
            }
        }
        return root;
    }
}
