package com.npc.algorithms.link2;

import com.npc.algorithms.link.ListNode;
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

        System.out.println();

        ListNode node = reverseList(head);
        Util.p(node);
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
