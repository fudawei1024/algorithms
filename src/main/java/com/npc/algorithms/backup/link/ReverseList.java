package com.npc.algorithms.backup.link;

import com.npc.algorithms.util.Util;

public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5, new ListNode(6,null))))));

        Util.p(head);

        System.out.println();

        ListNode node = recurison(null, head) ;
        //node = reverseList(node);
        Util.p(node);
    }


    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode current = head;

        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

   public static ListNode recurison(ListNode pre, ListNode curent) {
        if (curent == null) {
            return pre;
        }

        ListNode next = curent.next;
        curent.next = pre;
        pre = curent;
        curent = next;
        return recurison(pre, curent);
   }
}
