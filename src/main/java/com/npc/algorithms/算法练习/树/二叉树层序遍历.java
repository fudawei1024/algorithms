package com.npc.algorithms.算法练习.树;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;

import java.util.*;

public class 二叉树层序遍历 {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);

        TreeOperation.show(treeNode);

        List<Integer> datas = levell(treeNode);
        datas.forEach(item -> {
            System.out.print(item + "  ");
        });
    }


    public static List<Integer> levell(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> valueList = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = que.size();
            while (size -- > 0) {
                TreeNode node = que.poll();
                levelList.add(node.value);
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            valueList.add(-1);
           valueList.addAll(levelList);
        }
        return valueList;
    }

    private static List<Integer> level(TreeNode root) {
       List<Integer> resList = new ArrayList<>();
       if (root == null) {
           return resList;
       }

       Queue<TreeNode> que = new LinkedList<>();
       que.offer(root);
       while(!que.isEmpty()) {
           List<Integer> levelList = new ArrayList<>();
           int length = que.size();

           while(length -- > 0) {
               TreeNode node = que.poll();
               levelList.add(node.value);
               if (node.left != null) {
                   que.offer(node.left);
               }
               if (node.right != null) {
                   que.offer(node.right);
               }
           }

           resList.addAll(levelList);
       }

       return resList;
    }

    private static List<Integer> levelResve(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int length = que.size();

            while(length > 0) {
                TreeNode node = que.poll();
                levelList.add(node.value);

                if (node.right != null) {
                    que.offer(node.right);
                }
                if (node.left != null) {
                    que.offer(node.left);
                }
                length --;
            }

            resList.addAll(levelList);
        }

        Collections.reverse(resList);
        return resList;
    }
}
