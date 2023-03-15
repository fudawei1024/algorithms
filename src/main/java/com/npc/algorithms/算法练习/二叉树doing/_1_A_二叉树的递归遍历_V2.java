package com.npc.algorithms.算法练习.二叉树doing;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;
import com.npc.algorithms.util.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fudawei
 * @date 2022年07月19日 17:58
 * @desc
 */
public class _1_A_二叉树的递归遍历_V2 {

    @Test
    public void testSearch() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);


        TreeOperation.show(root);

        List<Integer> pre1 = preOrderTraversal(root);

        Util.pL("前序遍历1：", pre1);


        List<Integer> mid1 = mindTraversal(root);
        Util.pL("中序遍历1：", mid1);


        List<Integer> end1 = endTraversal(root);

        Util.pL("后序遍历1：", end1);
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(result, root);
        return result;
    }


    public void preOrderTraversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.value);
        preOrderTraversal(result, root.left);
        preOrderTraversal(result, root.right);
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
        result.add(root.value);
        mindTraversal(result, root.right);
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
        result.add(root.value);
    }
}
