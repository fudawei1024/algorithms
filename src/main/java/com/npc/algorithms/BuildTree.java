package com.npc.algorithms;

import com.npc.algorithms.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;
import com.npc.algorithms.util.Util;

/**
 * @projectName: algorithms
 * @package: com.npc.algorithms
 * @className: BuildTree
 * @author: fudawei
 * @description: TODO
 * @date: 2022/1/26 16:54
 * @version: 1.0
 */
public class BuildTree {
    public static TreeNode createTree(int rootIndex, int[] values) {
        if (rootIndex >= values.length) {
            return null;
        }
        TreeNode rootNode = new TreeNode(values[rootIndex]);
        rootNode.left = createTree(2 * rootIndex + 1, values);
        rootNode.right =(createTree(2 * rootIndex + 2, values));
        return rootNode;
    }

    public static void main(String[] args) {
       Integer.parseInt("999999999999999");
    }
}