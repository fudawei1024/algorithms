package com.npc.algorithms.backup.tree;

import com.npc.algorithms.util.TreeOperation;

public class 最大二叉树 {

    public static void main(String[] args) {
        int[] order = new int[]{3,2,1,6,0,5};
        TreeNode root = constructMaximumBinaryTree(order, 0 ,order.length);
        TreeOperation.show(root);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l == r)
            return null;
        int max_i = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = constructMaximumBinaryTree(nums, l, max_i);
        root.right = constructMaximumBinaryTree(nums, max_i + 1, r);
        return root;
    }
    public static int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }
}
