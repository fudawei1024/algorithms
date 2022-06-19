package com.npc.algorithms.backup.link;

import com.npc.algorithms.backup.util.Util;

public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5, new ListNode(6, null))))));
        Util.p(head);
        Util.pl();
        ListNode swpHead = swapPaire(head);
        Util.p(swpHead);
    }

    private static ListNode swapPaire(ListNode head) {
       if (head == null) return null;

       ListNode dummyNode = new ListNode(0, head);
       ListNode pre = dummyNode;

       while (pre.next != null &&  pre.next.next != null) {
          ListNode tmpNode = head.next.next;
          pre.next = head.next;
          head.next.next = head;
          head.next = tmpNode;
          pre = head;
          head = tmpNode;
       }
       return dummyNode.next;

    }
}
