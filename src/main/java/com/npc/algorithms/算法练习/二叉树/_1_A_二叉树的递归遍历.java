package com.npc.algorithms.算法练习.二叉树;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;
import com.npc.algorithms.util.Util;
import org.junit.Test;

import java.util.*;

/**
 * @author fudawei
 * @date 2022年07月19日 17:58
 * @desc
 */
public class _1_A_二叉树的递归遍历 {

    @Test
    public void testSearch() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);


        TreeOperation.show(root);

        List<Integer> pre1 = preorderTraversal(root);
        List<Integer> pre2 = preorderTraversal2(root);

        Util.pL("前序遍历1：", pre1);
        Util.pL("前序遍历2：", pre2);


        List<Integer> mid1 = mindTraversal(root);
        List<Integer> mid2 = mindTraversal2(root);
        Util.pL("中序遍历1：", mid1);
        Util.pL("中序遍历2：", mid2);


        List<Integer> end1 = endTraversal(root);
        List<Integer> end2 = endTraversal2(root);

        Util.pL("后序遍历1：", end1);
        Util.pL("后序遍历2：", end2);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(result, root);
        return result;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
                if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。
            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }

    public void preorderTraversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversal(result, root.left);
        preorderTraversal(result, root.right);
    }

    public List<Integer> mindTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        mindTraversal(result, root);
        return result;
    }

    public void mindTraversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        mindTraversal(result, root.left);
        result.add(root.val);
        mindTraversal(result, root.right);
    }

    public List<Integer> mindTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。
                if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）

            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }

    public List<Integer> endTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                stack.push(node);
                stack.push(null);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                stack.pop();
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }

    public List<Integer> endTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        endTraversal(result, root);
        return result;
    }

    public void endTraversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        endTraversal(result, root.left);
        endTraversal(result, root.right);
        result.add(root.val);
    }
}
