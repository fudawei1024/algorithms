package com.npc.algorithms.算法练习.树;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class 二叉树前序迭代遍历 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);

        TreeOperation.show(treeNode);

        List<Integer> datas = new ArrayList<>();
        preorderTraversal(treeNode, datas);
        datas.forEach(item -> {
            System.out.print(item + "  ");
        });
    }

    private static void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.value);
        if (root.left != null) {
            preorderTraversal(root.left, result);
        }
        if (root.right != null) {
            preorderTraversal(root.right, result);
        }
    }

    private static List<Integer> preorderTraversalLoop(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
           TreeNode cur =  stack.pop();
           if (cur.right != null) {
               stack.push(cur.right);
           }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            result.add(cur.value);
        }

        return result;
    }
}
