package com.npc.algorithms.backup.link2;

import com.npc.algorithms.backup.link.ListNode;
import com.npc.algorithms.util.Util;


/**
 * @className: T2_反转链表
 * @author: fudawei
 * @description:
 * 题意：反转一个单链表。
 *
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 *
 * @date: 2022/2/14 18:06
 * @version: 1.0
 */
public class T3_反转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5, new ListNode(6,null))))));
        Util.p(head);

        Util.pl();

        ListNode node = reerseList(head);
        Util.p(node);
    }

    public static ListNode reerseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

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
}
