package com.npc.algorithms.算法练习.链表;

import com.npc.algorithms.backup.link.ListNode;
import com.npc.algorithms.util.Util;
import org.junit.Test;

/**
 *给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *示例 1：
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-linked-list-elements
 */
public class _3_A_反转链表 {


    @Test
    public void test() {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = Util.array2List(nums);
        Util.pV(reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }

        ListNode tmp = null;
        tmp = cur.next;
        cur.next = pre;
        return reverse(cur, tmp);
    }
}
