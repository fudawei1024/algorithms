package com.npc.algorithms.backup.link2;

import com.npc.algorithms.backup.link.ListNode;
import com.npc.algorithms.util.Util;

/**
 * @className: T4_两两交换链表中的节点
 * @author: fudawei
 * @description:
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @date: 2022/2/15 12:03
 * @version: 1.0
 */
public class T4_两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5,null)))));

        //ListNode head = new ListNode(1, null);
        Util.p(head);

        System.out.println();

        ListNode node = swapPair(head);
        Util.p(node);
    }

    private static ListNode swapPaire(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode swpNode = swapPaire(next.next);
        next.next = head;
        head.next = swpNode;
        return next;
    }

    private static ListNode swapPair(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode swpNode = swapPair(next.next);
        next.next = head;
        head.next = swpNode;

        return next;
    }
}
