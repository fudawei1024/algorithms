package com.npc.algorithms.tree;

import com.npc.algorithms.util.TreeOperation;

import java.util.*;

public class Iterator {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);

        TreeOperation.show(treeNode);

        List<Integer> datas = preorderTraversal(treeNode);
        datas.forEach(item -> {
            System.out.print(item + "  ");
        });
    }

    public static void ergodic(TreeNode treeNode, List<Integer> datas) {
        if (treeNode == null) {
            return ;
        }

        ergodic(treeNode.left, datas);
        datas.add(treeNode.val);
        ergodic(treeNode.right, datas);
    }


    // 前序遍历顺序：中-左-右，入栈顺序：中-右-左
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right!=null){
                    st.push(node.right);  // 添加右节点（空节点不入栈）
                }
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

                if (node.left!=null) {
                    st.push(node.left);    // 添加左节点（空节点不入栈）
                }
            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                stack.push(node);
                stack.push(null);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                stack.pop();
                TreeNode cnode = stack.peek();
                stack.pop();
                result.add(cnode.val);
            }
        }
        return result;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
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
                stack.pop();
                TreeNode cnode = stack.peek();
                stack.pop();
                result.add(cnode.val);
            }
        }
        return result;
    }
}
