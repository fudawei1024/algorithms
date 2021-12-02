package com.npc.algorithms.tree;

import com.npc.algorithms.util.ListUtil;
import com.npc.algorithms.util.TreeOperation;
import com.npc.algorithms.util.Util;

import java.util.ArrayList;
import java.util.List;

public class 从中序与后续遍历序列构造二叉树 {

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

        List<Integer> mid = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        mid(treeNode, mid);
        end(treeNode, end);

        Util.p(ListUtil.toArray(mid));
        System.out.println();
        Util.p(ListUtil.toArray(end));
        System.out.println();

        TreeNode root =  buildTree(ListUtil.toArray(mid), ListUtil.toArray(end));
        TreeOperation.show(root);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight) return null;

        if (inLeft == inRight) {
            return new TreeNode(inorder[inLeft]);
        }

        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        root.left = buildTree(inorder, inLeft, rootIndex - 1, postorder, postLeft, postLeft + (rootIndex - inLeft - 1));
        root.right = buildTree(inorder, rootIndex + 1, inRight, postorder, postLeft + (rootIndex - inLeft) + 1, postRight-1);

        return root;
    }


//    public static TreeNode buildTree(int[] inorder, int[] postorder) {
//        return buildTree1(inorder, 0, inorder.length, postorder, 0, postorder.length);
//    }
    public static TreeNode buildTree1(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        // 没有元素了
        if (inRight - inLeft < 1) {
            return null;
        }
        // 只有一个元素了
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }
        // 后序数组postorder里最后一个即为根结点
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        // 根据根结点的值找到该值在中序数组inorder里的位置
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        // 根据rootIndex划分左右子树
        System.out.println(String.format("left === inLeft:%s  inRight:%s  postLeft:%s  postRight:%s", inLeft, rootIndex, postLeft, postLeft + (rootIndex - inLeft)));
        root.left = buildTree1(inorder, inLeft, rootIndex,
                postorder, postLeft, postLeft + (rootIndex - inLeft));
        System.out.println(String.format("right=== inLeft:%s  inRight:%s  postLeft:%s  postRight:%s", rootIndex + 1, inRight, postLeft + (rootIndex - inLeft), postRight - 1));
        root.right = buildTree1(inorder, rootIndex + 1, inRight,
                postorder, postLeft + (rootIndex - inLeft), postRight - 1);
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
    public static void end(TreeNode root, List<Integer> data) {
        if (root == null ) {
            return;
        }
        if (data == null) {
            data = new ArrayList<>();
        }
        end(root.left, data);
        end(root.right, data);
        data.add(root.val);
    }
}
