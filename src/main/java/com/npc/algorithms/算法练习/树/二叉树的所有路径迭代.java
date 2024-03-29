package com.npc.algorithms.算法练习.树;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的所有路径迭代 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);
        treeNode.right.left.right = new TreeNode(14);
        treeNode.right.left.right.left = new TreeNode(14);

        TreeOperation.show(treeNode);


        List<String> paths = binaryTreePaths2(treeNode);
        for (String path : paths) {
            System.out.println(path);
        }
    }

    private static List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return null;
        }

        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.value + "");
        while (!stack.isEmpty()) {
            String path = (String)stack.pop();
            TreeNode node = (TreeNode)stack.pop();
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->"  + node.right.value);
            }
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->"  +  node.left.value);
            }
        }
        return res;
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.value + "");
        while (!stack.isEmpty()) {
            String path = (String)stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            if (node.left == null && node.right == null) {
                res.add(path);
            }

            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.value);
            }
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.value);
            }
        }
        return res;
    }

}