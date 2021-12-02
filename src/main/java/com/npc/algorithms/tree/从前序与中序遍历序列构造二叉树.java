package com.npc.algorithms.tree;

import com.npc.algorithms.util.ListUtil;
import com.npc.algorithms.util.TreeOperation;
import com.npc.algorithms.util.Util;

import java.util.ArrayList;
import java.util.List;

public class 从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);

        TreeOperation.show(treeNode);
        System.out.println();

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        front(treeNode, in);
        mid(treeNode, pre);

        Util.p(ListUtil.toArray(in));
        System.out.println();
        Util.p(ListUtil.toArray(pre));
        System.out.println();

        TreeNode root =  buildTree1(ListUtil.toArray(in), ListUtil.toArray(pre));
        TreeNode root2 = buildTree(ListUtil.toArray(in), ListUtil.toArray(pre));
        TreeOperation.show(root);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    public static TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                              int[] inorder, int inLeft, int inRight) {
        // 递归终止条件
        if (inLeft > inRight || preLeft > preRight) return null;

        if (inLeft == inRight) {
            return new TreeNode(inorder[inLeft]);
        }

        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = inLeft; i <=inRight ; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        System.out.println(String.format("慢 left === preLeft:%s  preRight:%s  inLeft:%s  inRight:%s", preLeft + 1, rootIndex, inLeft, inLeft + (rootIndex - inLeft) - 1));
        root.left = buildTree(preorder, preLeft + 1, rootIndex + 1, inorder, inLeft, inLeft + (rootIndex - inLeft) - 1);
        System.out.println(String.format("慢 right === preLeft:%s  preRight:%s  inLeft:%s  inRight:%s", rootIndex + 1,preRight, inLeft + (rootIndex - inLeft) + 1, inRight));
        root.right = buildTree(preorder, rootIndex + 1, preRight, inorder,inLeft + (rootIndex - inLeft) + 1, inRight);

        return root;
    }



    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        return buildTree1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public static TreeNode buildTree1(int[] preorder, int preLeft, int preRight,
                              int[] inorder, int inLeft, int inRight) {
        // 递归终止条件
        if (inLeft > inRight || preLeft > preRight) return null;
        if (inLeft == inRight) {
            return new TreeNode(inorder[inLeft]);
        }


        int rootIndex = 0, rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        for (int i = inLeft; i <=inRight ; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        System.out.println(String.format("快 left === preLeft:%s  preRight:%s  inLeft:%s  inRight:%s", preLeft + 1, preLeft + (rootIndex - inLeft), inLeft, rootIndex - 1));
        root.left = buildTree1(preorder, preLeft + 1, preLeft + (rootIndex - inLeft), inorder, inLeft, rootIndex - 1);
        System.out.println(String.format("快 right === preLeft:%s  preRight:%s  inLeft:%s  inRight:%s", preLeft + (rootIndex - inLeft) + 1, preRight, rootIndex + 1, inRight));
        root.right = buildTree1(preorder,  preLeft + (rootIndex - inLeft) + 1, preRight, inorder, rootIndex + 1, inRight);
        return root;
    }


    public static void front(TreeNode root, List<Integer> data) {
        if (root == null ) {
            return;
        }
        if (data == null) {
            data = new ArrayList<>();
        }
        data.add(root.val);
        front(root.left, data);
        front(root.right, data);
    }

    public static void mid(TreeNode root, List<Integer> data) {
        if (root == null ) {
            return;
        }
        if (data == null) {
            data = new ArrayList<>();
        }
        mid(root.left, data);
        data.add(root.val);
        mid(root.right, data);
    }
}
