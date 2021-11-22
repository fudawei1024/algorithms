package com.npc.algorithms.tree;

import jdk.nashorn.internal.objects.annotations.Constructor;

/**
 * @projectName: algorithms
 * @package: com.npc.algorithms.tree
 * @className: TreeNode
 * @author: fudawei
 * @description: TODO
 * @date: 2021/11/20 16:08
 * @version: 1.0
 */

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public TreeNode next;

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
