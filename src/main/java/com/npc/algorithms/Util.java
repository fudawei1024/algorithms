package com.npc.algorithms;

import com.npc.algorithms.list.ListNode;

public class Util {
    public static void p(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void pl() {
        System.out.println();
    }
}
