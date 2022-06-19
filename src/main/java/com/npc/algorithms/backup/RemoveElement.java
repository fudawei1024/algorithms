package com.npc.algorithms.backup;

/**
 * @projectName: algorithms
 * @package: com.npc.algorithms
 * @className: RemoveElement
 * @author: fudawei
 * @description: TODO
 * @date: 2021/11/9 20:01
 * @version: 1.0
 */
public class RemoveElement {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);



        ListNode reverseList = reverseList(head);
        while(reverseList != null) {
            System.out.print(reverseList.val + "  ");
            reverseList =reverseList.next;
        }

        //  System.out.println(removeElement(new int[]{1,23,55,6,7,4,8,2,9}, 8));
    }

    public static int removeElement(int[] array, int val) {
        if (array == null) {
            return 0;
        }
        int slow=0,fast=0;
        for (int i = 0; i < array.length; i++) {

        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur  = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     /**
      *  ListNode prev = null;
      *         ListNode curr = head;
      *         while (curr != null) {
      *             ListNode nextTemp = curr.next;
      *             curr.next = prev;
      *             prev = curr;
      *             curr = nextTemp;
      *         }
      *         return prev;
      */
 }
