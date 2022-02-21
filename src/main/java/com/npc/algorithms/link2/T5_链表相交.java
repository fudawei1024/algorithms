package com.npc.algorithms.link2;

import com.npc.algorithms.link.ListNode;
import com.npc.algorithms.util.Util;

/**
 * @className: T5_链表相交
 * @author: fudawei
 * @description:
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * @date: 2022/2/15 16:19
 * @version: 1.0
 */
public class T5_链表相交 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3)));


        ListNode node4 = new ListNode(4, new ListNode(5, new ListNode(6)));

        head.next.next.next = node4;
        head2.next.next.next = node4;

        Util.p(head);
        Util.pl();
        Util.p(head2);
        ListNode swpHead = joinPoint(head, head2);
        Util.p(swpHead);
    }

    private static ListNode joinPoint(ListNode head, ListNode head2) {
        if (head == null || head2 == null) {
            return null;
        }
        ListNode nodeA = head;
        ListNode nodeB = head2;

        int lengthA = 0;
        int lengthB = 0;

        while (nodeA != null) {
            lengthA++;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            lengthA++;
            nodeB = nodeB.next;
        }

        int count = lengthB - lengthA;
        while (count-- > 0) {

        }
        return null;
    }
}
