package com.npc.algorithms.算法练习.树;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;
import com.npc.algorithms.util.Util;

public class 是否为搜索二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        TreeOperation.show(root);
        System.out.println();
        Util.p(isBST(root));
    }


    static int preValue = Integer.MIN_VALUE;

    private static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isBST(root.left)) {
            return false;
        }

        if (root.value <= preValue) {
            return false;
        } else {
            preValue = root.value;
        }

        return isBST(root.right);
    }

}
