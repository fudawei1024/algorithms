package com.npc.algorithms.算法练习.链表;

import com.npc.algorithms.backup.link.ListNode;
import com.npc.algorithms.backup.util.Util;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 *
 */
public class _5_A_删除链表的倒数第N个结点 {

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5,6,7};
        ListNode head = Util.array2List(nums);
        Util.pV(head);
        Util.pl();
        Util.pV(removeNthFromEnd2(head, 1));
        Util.pl();
        Util.pV(removeNthFromEnd2(head, 2));

    }

    public ListNode removeNthFromEnd(ListNode head, Integer n) {

        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy.next, fast = dummy.next, prev = null;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
       return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, Integer n) {

        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode tmp = dummy.next;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        while (n-- > 0) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }
}
