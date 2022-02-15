package com.npc.algorithms.link2;

import com.npc.algorithms.link.ListNode;
import com.npc.algorithms.util.Util;

import java.util.List;

/**
 * @className: T5_删除链表的倒数第N个节点
 * @author: fudawei
 * @description:
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * @date: 2022/2/15 12:18
 * @version: 1.0
 */
public class T5_删除链表的倒数第N个节点 {
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5, new ListNode(6, null))))));
        Util.p(head);
        Util.pl();
        ListNode swpHead = removeNthFromEnd(head, 1);
        Util.p(swpHead);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        if (head == null || n < 0) {
            return head;
        }

        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n -- > 0) {
            if (fast == null) {
                return dummy.next;
            }
            fast = fast.next;
        }

        ListNode prov = null;
        while (fast != null) {
            prov = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prov.next = slow.next;
        return dummy.next;
    }
}
