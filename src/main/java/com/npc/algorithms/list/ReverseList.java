package com.npc.algorithms.list;

import com.npc.algorithms.Util;

public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5, new ListNode(6,null))))));

        //ListNode head = new ListNode(1, null);
        Util.p(head);

        System.out.println();

        ListNode node = reverseList2(head);
        Util.p(node);
    }

    private static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static ListNode reverseList2(ListNode head) {
       return reverse(null, head);
    }

    private static ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
        return reverse(pre, cur);
    }
}
