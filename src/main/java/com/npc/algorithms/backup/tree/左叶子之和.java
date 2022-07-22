package com.npc.algorithms.backup.tree;

import com.npc.algorithms.util.TreeOperation;

import java.util.Stack;


public class 左叶子之和 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);

        TreeOperation.show(treeNode);
        System.out.println(sumOfLeftLeaves(treeNode));
        System.out.println(sumOfLeftLeaves2(treeNode));
    }

    private static int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) return res;

       Stack<TreeNode> stack = new Stack<>();
       stack.push(root);
       while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }

                stack.push(node);
                stack.push(null);
            } else {
                stack.pop();           // 将空节点弹出
                node = stack.peek();    // 重新取出栈中元素
                stack.pop();
                if (node.left != null && node.left.left == null && node.left.right == null) {
                    res += node.left.val;
                }
            }
       }
       return res;
    }



    private static int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);

        int minValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            minValue = root.left.val;
        }
        return left + right  + minValue;
    }
}
