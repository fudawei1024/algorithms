package com.npc.algorithms.link;

import com.npc.algorithms.util.Util;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5, new ListNode(6, null))))));
        Util.p(head);
        Util.pl();
        ListNode swpHead = removeNthFromEnd(head, 1);
        Util.p(swpHead);
    }

    private static ListNode removeNthFromEnd(ListNode head, int index) {
        if (head == null) {
            return head;
        }

        if (index == 1) {
            return head.next;
        }

        ListNode node = head;
        ListNode slow = null;
        ListNode fast = node;
        int count = 0;
        while (fast != null) {
            if (count < index){
                fast = fast.next;
                count ++;
            }

            fast = fast.next;
            if (slow == null) {
                slow = node;
            } else {
                slow = slow.next;
            }
        }

        if (count == index &&  slow.next != null) {
            slow.next = slow.next.next;
        }

        return head;
    }
}
