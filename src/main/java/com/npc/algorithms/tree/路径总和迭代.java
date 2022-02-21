package com.npc.algorithms.tree;

import com.npc.algorithms.util.TreeOperation;


import java.util.LinkedList;
import java.util.Queue;

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

    private static boolean traversal(TreeNode root, int targetsum) {
        if (root == null) return false;
        Queue<TreeNode> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        que1.offer(root);
        que2.offer(root.val);
        while (!que1.isEmpty()) {
            int size = que1.size();
            while (size -- > 0) {
                TreeNode node = que1.poll();
                System.out.print(node.val + "  ");
                int sum = que2.poll();
                // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
                if (node.left == null && node.right == null && sum == targetsum) return true;
                // 左节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if (node.left != null) {
                    que1.offer(node.left);
                    que2.offer(sum + node.left.val);
                }
                // 右节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if (node.right != null) {
                    que1.offer(node.right);
                    que2.offer(sum + node.right.val);
                }

            }
        }
        return false;
    }
}
