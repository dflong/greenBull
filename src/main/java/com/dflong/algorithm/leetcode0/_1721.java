package com.dflong.algorithm.leetcode0;

public class _1721 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(100);
        listNode.next = new ListNode(90);
//        listNode.next.next = new ListNode(6);
//        listNode.next.next.next = new ListNode(6);
//        listNode.next.next.next.next = new ListNode(7);
//        listNode.next.next.next.next.next = new ListNode(8);
//        listNode.next.next.next.next.next.next = new ListNode(3);
//        listNode.next.next.next.next.next.next.next = new ListNode(0);
//        listNode.next.next.next.next.next.next.next.next = new ListNode(9);
//        listNode.next.next.next.next.next.next.next.next.next = new ListNode(5);

        new _1721().swapNodes(listNode, 2);
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode fast = hair;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        ListNode k1Prev = fast, k1 = fast.next, k1Next = k1.next;

        fast = fast.next;
        ListNode slow = hair;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode k2Prev = slow, k2 = slow.next, k2Next = k2.next;

        if (k1 == k2) {
            return hair.next;
        }
        if (k1.next == k2) {
            k1Prev.next = k2;
            k2.next = k1;
            k1.next = k2Next;
            return hair.next;
        }
        if (k2.next == k1) {
            k2Prev.next = k1;
            k1.next = k2;
            k2.next = k1Next;
            return hair.next;
        }
        k1Prev.next = k2;
        k2.next = k1Next;

        k2Prev.next = k1;
        k1.next = k2Next;

        return hair.next;
    }
}
