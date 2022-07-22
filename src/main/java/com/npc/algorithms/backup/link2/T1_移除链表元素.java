package com.npc.algorithms.backup.link2;

import com.npc.algorithms.backup.link.ListNode;
import com.npc.algorithms.util.Util;

/**
 * @className: T1_移除链表元素
 * @author: fudawei
 * @description:
 *
 * 题意：删除链表中等于给定值 val 的所有节点。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * @date: 2022/2/14 14:38
 * @version: 1.0
 */
public class T1_移除链表元素 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(1, new ListNode(5, null)))));
        Util.p(head);

        System.out.println();

        ListNode node2 = removeElements(head, 2);
        Util.p(node2);
    }


    private static ListNode removeElements(ListNode head, int val) {
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

    private static ListNode removeElements2(ListNode head, int val) {
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
