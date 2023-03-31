package com.npc.algorithms.算法练习.树;

import com.npc.algorithms.backup.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层平均值 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(16);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(9);
        treeNode.right.left = new TreeNode(14);
        treeNode.right.right = new TreeNode(19);

        TreeOperation.show(treeNode);

        List<Double> datas = averageOfLevels(treeNode);
        datas.forEach(item -> {
            System.out.print(item + "  ");
        });
    }

    private static List<Double> averageOfLevels(TreeNode root) {
        List<Double> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int length = que.size();
            Double sum = 0.0;
            int count = 0;
            while (length > 0) {
                TreeNode node = que.poll();
                sum += node.value * 1.0;
                count ++;
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
                length --;
            }
            resList.add(sum / count);
        }
        return resList;
    }
}
