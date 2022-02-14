package com.npc.algorithms.link;

import com.npc.algorithms.util.Util;

public class RemoveElement {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5, null)))));
        Util.p(head);

        System.out.println();

        ListNode node2 = removeElement(head, 1);
        Util.p(node2);

    }

    public static ListNode removeElement(ListNode head, int val) {
       while (head != null && head.val == val) {
           head = head.next;
       }
       if (head == null) {
           return head;
       }

       ListNode pre = head;
       ListNode cur = head.next;
       while (cur != null) {
           if (cur.val == val) {
               pre.next = cur.next;
           } else {
               pre = cur;
           }
           cur = cur.next;
       }
       return head;
    }
}

