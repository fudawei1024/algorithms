package com.npc.algorithms.算法练习.链表;

import com.npc.algorithms.backup.link.ListNode;
import com.npc.algorithms.backup.util.Util;
import org.junit.Test;

/**
 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。

 在链表类中实现这些功能：

 get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
 addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
 addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
 addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。


 示例：

 MyLinkedList linkedList = new MyLinkedList();
 linkedList.addAtHead(1);
 linkedList.addAtTail(3);
 linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 linkedList.get(1);            //返回2
 linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 linkedList.get(1);            //返回3

 提示：

 所有val值都在[1, 1000]之内。
 操作次数将在 [1, 1000]之内。
 请不要使用内置的 LinkedList 库。

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/design-linked-list
 */
public class _2_A_设计链表 {


    @Test
    public void test() {

        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(4);
//        myLinkedList.addAtHead(3);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(1);

        myLinkedList.addAtTail(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtTail(4);
        myLinkedList.addAtTail(5);


        Util.pV(myLinkedList.getHead());
        Util.pl();
        myLinkedList.addAtTail(6);
        Util.pl();
        Util.pV(myLinkedList.getHead());
        Util.pl();
        myLinkedList.deleteAtIndex(5);
        Util.pV(myLinkedList.getHead());
    }
}

class MyLinkedList extends ListNode {
    int size;
    ListNode head;

    public ListNode getHead () {
        return head.next;
    }

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (size <= 0 || index < 0) {
            return -1;
        }

        ListNode node = head;
        for (int i = 0; i <= index; i++) {
            if (node == null) {
                return -1;
            }
            node = node.next;
        }
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (size < 0 || index < 0) {
            return;
        }

        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        if (node != null) {
            ListNode addNode = new ListNode(val);
            ListNode tmp = node.next;
            node.next = addNode;
            addNode.next = tmp;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (size <= index || index < 0) {
            return;
        }

        ListNode node = head;
        for (int i = 0; i < index; i++) {
            if (node == null) {
               return ;
            }
            node = node.next;
        }
        if (node != null)  {
            node.next = node.next.next;
        }
    }
}
