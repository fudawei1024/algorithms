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

    public static void p(char[] str) {
        if (str != null && str.length > 0) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
        }
    }
}
