package com.npc.algorithms.backup.tree;

import com.npc.algorithms.util.TreeOperation;
import com.npc.algorithms.util.Util;

public class 验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        TreeOperation.show(root);
        System.out.println();
        Util.p(getMinimumDifference(root));
    }

    // 递归
    static TreeNode preNode;
    static int result = Integer.MAX_VALUE;
    private static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMinimumDifference(root.left);
        if (preNode != null) {
            result = Math.min(result , root.value - preNode.value);
        }
        preNode = root;
        getMinimumDifference(root.right);
        return result;
    }
}
