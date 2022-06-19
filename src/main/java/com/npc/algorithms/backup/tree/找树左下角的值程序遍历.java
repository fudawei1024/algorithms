package com.npc.algorithms.backup.tree;

import com.npc.algorithms.backup.util.TreeOperation;

import java.util.LinkedList;
import java.util.Queue;

public class 找树左下角的值程序遍历 {

    static int Deep = -1;
    static int value = 0;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);

        TreeOperation.show(treeNode);
        System.out.println(findBottomLeftValue2(treeNode));
    }

    private static void findLeftValue(TreeNode root, int deep) {
        if (root != null && root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
            return;
        }
        if (root.left != null) findLeftValue(root.left, deep + 1);
        if (root.right != null) findLeftValue(root.right, deep + 1);
    }

    private static int findBottomLeftValue2(TreeNode root) {
        if (root == null) return value;
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    private static int findBottomLeftValue(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size(), tmp = size;
            while (size > 0) {
                TreeNode node = que.poll();
                if (tmp == size) {
                    res = node.val;
                }
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
                size --;
            }
        }
        return res;
    }
}
