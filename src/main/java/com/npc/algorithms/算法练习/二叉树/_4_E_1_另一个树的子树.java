package com.npc.algorithms.算法练习.二叉树;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 *
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * root 树上的节点数量范围是 [1, 2000]
 * subRoot 树上的节点数量范围是 [1, 1000]
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subtree-of-another-tree
 */
public class _4_E_1_另一个树的子树 {

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

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(7);
//        root2.left.left = new TreeNode(1);
//        root2.left.right = new TreeNode(3);
//        root2.right.left = new TreeNode(3);
//        root2.right.right = new TreeNode(1);
        TreeOperation.show(root2);


        Assert.assertTrue(!isSubtree(root, root2));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }
}
