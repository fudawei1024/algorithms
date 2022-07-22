package com.npc.algorithms.算法练习.二叉树doing;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;
import org.junit.Test;

import java.util.*;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 示例 2：
 *
 *
 *
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/invert-binary-tree
 */
public class _3_A_翻转二叉树 {

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
        TreeOperation.show(invertTree(root));
    }


//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return root;
//        }
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//        root.left = right;
//        root.right = left;
//        return root;
//    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {return null;}
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                swap(node);
                if (node.left != null) {deque.offer(node.left);}
                if (node.right != null) {deque.offer(node.right);}
            }
        }
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
