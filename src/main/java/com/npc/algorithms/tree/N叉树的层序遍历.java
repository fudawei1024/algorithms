package com.npc.algorithms.tree;

import com.npc.algorithms.util.TreeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N叉树的层序遍历 {

    public static void main(String[] args) {
        Node node = new Node(1);
        List<Node> childList1 = new ArrayList<>();

        List<Node> childList2 = new ArrayList<>();
        childList2.add(new Node(5));
        childList2.add(new Node(6));
        childList1.add(new Node(3, childList2));
        childList1.add(new Node(2));
        childList1.add(new Node(4));

        node.children = childList1;


        List<List<Integer>>  datas = levelOrder(node);

        for (List<Integer> level : datas) {
            for (Integer val : level) {
                System.out.print( val + "  ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>>  levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int length = que.size();
            List<Integer> levelList = new ArrayList<>();

            while (length > 0) {
                Node node = que.poll();
                levelList.add(node.val);
                if (node.children != null && node.children.size() > 0) {
                    for (Node curNode: node.children) {
                        que.offer(curNode);
                    }
                }
                length --;
            }
            resList.add(levelList);
        }
        return resList;
    }
}
