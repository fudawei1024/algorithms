package com.npc.algorithms.link2;


import com.npc.algorithms.link.ListNode;
import com.npc.algorithms.util.Util;


/**
 * @className: T2_反转链表
 * @author: fudawei
 * @description:
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @date: 2022/2/14 18:06
 * @version: 1.0
 */
public class T4_两两交换链表中的节点 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5)))));
        Util.p(head);
        Util.pl();
        ListNode swpHead = swapPairs(head);
        Util.p(swpHead);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        ListNode tmp = swapPairs(next.next);
        next.next = head;
        head.next = tmp;

      return next;
    }
}
