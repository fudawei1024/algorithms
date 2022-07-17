package com.npc.algorithms.backup.util;

import com.npc.algorithms.backup.link.ListNode;

import java.util.List;

public class Util {
    public static void p(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + "-" + node.hashCode() + "    ");
            node = node.next;
        }
    }

    public static void pV(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void pL(List list) {
       if (list == null) {return;}
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void pl() {
        System.out.println();
    }

    public static void p(char[] str) {
        if (str != null && str.length > 0) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
        }
    }
    public static void p(int[] str) {
        if (str != null && str.length > 0) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i] + " ");
            }
        }
        System.out.println();
    }

    public static void p(Boolean value) {
        System.out.println(value);
    }

    public static void p(int value) {
        System.out.println(value);
    }

    public static void p(List<List<Integer>> result) {
        if (result != null || result.size() > 0) {
            for (List<Integer> integerList : result) {
                for (Integer data : integerList) {
                    System.out.print(data + " ");
                }
                System.out.println();
            }
        }
    }

    public static void pList(List result) {
        if (result != null || result.size() > 0) {
            for (Object obj : result) {
                System.out.println(obj);
            }
        }
    }

    public static ListNode array2List(int[] array) {
        ListNode head = new ListNode(array[0]);
        ListNode temp = head;
        for (int i = 1; i < array.length; i++) {
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }
        return head;
    }
}
