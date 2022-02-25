package com.npc.algorithms;

import com.npc.algorithms.link.ListNode;
import com.npc.algorithms.tree.TreeNode;
import com.npc.algorithms.util.TreeOperation;
import com.npc.algorithms.util.Util;

/**
 * @className: List2Tree
 * @author: fudawei
 * @description: TODO
 * @date: 2022/2/24 17:12
 * @version: 1.0
 */
public class List2Tree {
    public static void main(String[] args) {
        com.npc.algorithms.link.ListNode head = new com.npc.algorithms.link.ListNode(1, new com.npc.algorithms.link.ListNode(2, new com.npc.algorithms.link.ListNode(3, new com.npc.algorithms.link.ListNode(4,new com.npc.algorithms.link.ListNode(5, null)))));
        Util.p(head);

        System.out.println();

        TreeNode tree = buidTree(head, null);
        TreeOperation.show(tree);
    }

    private static TreeNode buidTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }

        ListNode midNode = getMidNode(left, right);
        TreeNode root = new TreeNode(midNode.val);
        root.left = buidTree(left, midNode);
        root.right = buidTree(midNode.next, right);
        return root;
    }

    private static ListNode getMidNode(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
